package com.binance4j.core.interceptor;

import java.io.IOException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.UnableToSignException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * The parameters interceptor that injects the API Key Header into requests, and
 * signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {
	/** The API key http header. */
	public static final String API_KEY_HEADER = "X-MBX-APIKEY";
	/** The API key http header decorator. */
	public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
	/** The API key http full header. */
	public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";
	/** The signed http header decorator. */
	public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
	/** The signed http full header. */
	public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";
	/** The API public key */
	String key;
	/** The API private key */
	String secret;

	/**
	 * @param key    API public key.
	 * @param secret API private key.
	 */
	public AuthenticationInterceptor(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}

	/**
	 * Intercepts the request
	 * 
	 * @param chain Request chain.
	 */
	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();
		Request.Builder newRequestBuilder = original.newBuilder();
		boolean isApiKeyRequired = original.header(ENDPOINT_SECURITY_TYPE_APIKEY) != null;
		boolean isSignatureRequired = original.header(ENDPOINT_SECURITY_TYPE_SIGNED) != null;
		newRequestBuilder.removeHeader(ENDPOINT_SECURITY_TYPE_APIKEY).removeHeader(ENDPOINT_SECURITY_TYPE_SIGNED);
		// Endpoint requires sending a valid API-KEY
		if (isApiKeyRequired || isSignatureRequired) {
			newRequestBuilder.addHeader(API_KEY_HEADER, key);
		} // Endpoint requires signing the payload
		if (isSignatureRequired) {
			String payload = original.url().query();
			if (payload != null && !"".equals(payload)) {
				String signature = sign(payload, secret);
				HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
				newRequestBuilder.url(signedUrl);
			}
		} // Build new request after adding the necessary authentication information
		Request newRequest = newRequestBuilder.build();
		return chain.proceed(newRequest);
	}

	/**
	 * Sign the given message using the given secret.
	 *
	 * @param message message to sign.
	 * @param secret  secret key.
	 * @return a signed message.
	 */
	public static String sign(String message, String secret) throws UnableToSignException {
		try {
			Mac sha256HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
			sha256HMAC.init(secretKeySpec);
			return new String(Hex.encodeHex(sha256HMAC.doFinal(message.getBytes())));
		} catch (Exception e) {
			throw new UnableToSignException(e);
		}
	}

	/**
	 * Extracts the request body into a String.
	 *
	 * @return request body as a string.
	 */
	@SuppressWarnings("unused")
	private static String bodyToString(RequestBody request) throws ApiException {
		try (final Buffer buffer = new Buffer()) {
			if (request != null) {
				request.writeTo(buffer);
			} else {
				return "";
			}
			return buffer.readUtf8();
		} catch (IOException e) {
			throw new ApiException(-400, e.getMessage());
		}
	}

	/**
	 * Updates the API keys.
	 * 
	 * @param key    New public key.
	 * @param secret New secret key.
	 */
	public void updateKeys(String key, String secret) {
		this.key = key;
		this.secret = secret;
	}
}
