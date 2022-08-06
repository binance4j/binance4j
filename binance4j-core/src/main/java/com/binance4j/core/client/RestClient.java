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
	protected String key;
	/** The API private key. */
	protected String secret;
	/** The current API service */
	protected T service;
	/** The Jackson object mapper for deserialization. */
	protected ObjectMapper mapper = new ObjectMapper();
	/** */
	protected Converter.Factory converterFactory;
	/** */
	protected Dispatcher dispatcher;
	/** */
	protected OkHttpClient httpClient;
	/** */
	protected String apiUrl;
	/** */
	protected AuthenticationInterceptor interceptor;
	/** */
	protected OkHttpClient client;

	/**
	 * @param mapping Retrofit Service mapping interface.
	 * @param key     API public key.
	 * @param secret  API secret key.
	 */
	protected RestClient(Class<T> mapping, String key, String secret) {
		this.mapping = mapping;
		this.key = key;
		this.secret = secret;
		createService();
	}

	/**
	 * @param mapping    Retrofit Service mapping interface.
	 * @param key        API public key.
	 * @param secret     API secret key.
	 * @param useTestnet use testnet.
	 */
	protected RestClient(Class<T> mapping, String key, String secret, boolean useTestnet) {
		this.mapping = mapping;
		this.key = key;
		this.secret = secret;
		this.useTestnet = useTestnet;

		createService();
	}

	/** Generates the API service. */
	protected void createService() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		converterFactory = JacksonConverterFactory.create(mapper);
		dispatcher = new Dispatcher();
		httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
		apiUrl = String.format("https://%s", useTestnet ? testnetDomain : baseDomain);
		interceptor = new AuthenticationInterceptor(key, secret);
		client = httpClient.newBuilder().addInterceptor(interceptor).build();
		service = new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
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
		// We also update the authentication interceptor keys
		interceptor.updateKeys(key, secret);
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

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

}