package com.binance4j.core.client;

import com.binance4j.core.security.AuthenticationInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	/** URL base domain. */
	protected final String baseDomain = "api.binance.com";
	/** Testnet URL base domain. */
	protected final String testnetDomain = "testnet.binance.vision";
	/** Defines if the services use the test network. */
	protected boolean useTestnet = false;
	/** The retrofit API mapping. */
	protected Class<T> mapping;
	/** The API public key. */
	protected final String key;
	/** The API private key. */
	protected final String secret;
	/** The current API service */
	protected T service;
	/** The Jackson object mapper for deserialization. */
	protected ObjectMapper mapper = new ObjectMapper();

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
	 * @param mapping    The retrofit Service mapping interface.
	 * @param key        The API public key.
	 * @param secret     The API secret key.
	 * @param useTestnet use testnet.
	 */
	protected RestClient(Class<T> mapping, String key, String secret, boolean useTestnet) {
		this.mapping = mapping;
		this.key = key;
		this.secret = secret;
		this.useTestnet = useTestnet;
		service = createService();
	}

	/**
	 * Generates the retrofit service that makes the API calls
	 *
	 * @return The service responsible for making calls to the API.
	 */
	protected T createService() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		Converter.Factory converterFactory = JacksonConverterFactory.create(mapper);
		Dispatcher dispatcher = new Dispatcher();
		OkHttpClient httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
		AuthenticationInterceptor interceptor = new AuthenticationInterceptor(key, secret);
		String apiUrl = String.format("https://%s", useTestnet ? testnetDomain : baseDomain);
		OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();
		return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
	}

	/** @return the key */
	public String getKey() {
		return key;
	}

	/** @return the secret */
	public String getSecret() {
		return secret;
	}

	/**
	 * @return the baseDomain
	 */
	public String getBaseDomain() {
		return baseDomain;
	}

	/**
	 * @return the testnetDomain
	 */
	public String getTestnetDomain() {
		return testnetDomain;
	}

	/**
	 * @return the mapper
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
}