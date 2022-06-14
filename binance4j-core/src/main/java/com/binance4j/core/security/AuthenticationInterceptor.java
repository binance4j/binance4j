package com.binance4j.core.security;

import java.io.IOException;

import com.binance4j.core.exception.ApiException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;

/**
 * A request interceptor that injects the API Key Header into requests, and
 * signs messages, whenever required.
 */
public class AuthenticationInterceptor implements Interceptor {
    /** The API key http header */
    public static final String API_KEY_HEADER = "X-MBX-APIKEY";
    /** The API key http header decorator */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY = "APIKEY";
    /** The API key http full header */
    public static final String ENDPOINT_SECURITY_TYPE_APIKEY_HEADER = ENDPOINT_SECURITY_TYPE_APIKEY + ": #";
    /** The signed http header decorator */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED = "SIGNED";
    /** The signed http full header */
    public static final String ENDPOINT_SECURITY_TYPE_SIGNED_HEADER = ENDPOINT_SECURITY_TYPE_SIGNED + ": #";
    /**
     * The API public key
     */
    private final String key;

    /**
     * The API private key
     */
    private final String secret;

    /**
     * Constructor
     * 
     * @param key    The API public key
     * @param secret The API private key
     */
    public AuthenticationInterceptor(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }

    /**
     * Intercepts the request
     * 
     * @param chain The request chain
     */
    @NotNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request.Builder newRequestBuilder = original.newBuilder();

        boolean isApiKeyRequired = original.header(ENDPOINT_SECURITY_TYPE_APIKEY) != null;
        boolean isSignatureRequired = original.header(ENDPOINT_SECURITY_TYPE_SIGNED) != null;
        newRequestBuilder.removeHeader(ENDPOINT_SECURITY_TYPE_APIKEY)
                .removeHeader(ENDPOINT_SECURITY_TYPE_SIGNED);

        // Endpoint requires sending a valid API-KEY
        if (isApiKeyRequired || isSignatureRequired) {
            newRequestBuilder.addHeader(API_KEY_HEADER, key);
        }

        // Endpoint requires signing the payload
        if (isSignatureRequired) {
            String payload = original.url().query();
            if (payload != null && !"".equals(payload)) {
                String signature = HmacSHA256Signer.sign(payload, secret);
                HttpUrl signedUrl = original.url().newBuilder().addQueryParameter("signature", signature).build();
                newRequestBuilder.url(signedUrl);
            }
        }

        // Build new request after adding the necessary authentication information
        Request newRequest = newRequestBuilder.build();
        return chain.proceed(newRequest);
    }

    /**
     * Extracts the request body into a String.
     *
     * @return request body as a string
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
}
