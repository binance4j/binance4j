package com.binance4j.core.client;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;

import com.binance4j.core.exception.UnableToSignException;
import com.binance4j.core.security.AuthenticationInterceptor;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * A base client for the Binance API
 *
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#endpoint-security-type">security</a>
 */
public abstract class RestClient<T> {
	/** URL base domain prefix. */
	protected static String prefix = "api";
	/** URL base domain. */
	protected static String baseDomain = "binance.com";
	/** Testnet URL base domain. */
	protected static String testnetDomain = "testnet.binance.vision";
	/** Defines if the services use the test network. */
	protected static boolean useTestnet = false;
	/** The retrofit API mapping. */
	protected Class<T> mapping;
	/** The API public key. */
	protected String key;
	/** The API private key. */
	protected String secret;
	/** The current API service */
	protected T service;

	/** Constructor */
	protected RestClient() {
	}

	/**
	 * @param mapping The retrofit Service mapping interface.
	 * @param key     The API public key.
	 * @param secret  The API secret key.
	 */
	protected RestClient(Class<T> mapping, String key, String secret) {
		this.mapping = mapping;
		this.key = key;
		this.secret = secret;
		service = createService();
	}

	/**
	 * Generates the retrofit service that makes the API calls
	 *
	 * @return The service responsible for making calls to the API.
	 */
	protected T createService() {
		Converter.Factory converterFactory = JacksonConverterFactory.create();
		Dispatcher dispatcher = new Dispatcher();

		OkHttpClient httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
		AuthenticationInterceptor interceptor = new AuthenticationInterceptor(key, secret);

		String apiUrl = String.format("https://%s", !useTestnet ? baseDomain : testnetDomain);

		OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();

		return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
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

	/** @return the key */
	public String getKey() {
		return key;
	}

	/** @param key the key to set */
	public void setKey(String key) {
		this.key = key;
	}

	/** @return the secret */
	public String getSecret() {
		return secret;
	}

	/** @param secret the secret to set */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/** @return the mapping */
	public Class<T> getMapping() {
		return mapping;
	}

	/** @param mapping the mapping to set */
	public void setMapping(Class<T> mapping) {
		this.mapping = mapping;
	}
}