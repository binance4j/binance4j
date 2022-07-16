package com.binance4j.core.client;

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
	/** The client configuration. */
	protected RestClientConfiguration configuration;
	/** The retrofit API mapping. */
	protected Class<T> mapping;
	/** The API public key. */
	protected String key;
	/** The API private key. */
	protected String secret;
	/** The current API service */
	protected T service;

	protected RestClient() {
	}

	/**
	 * Instantiates a client for the corresponding mapping
	 *
	 * @param mapping The retrofit Service mapping interface
	 * @param key     The API public key
	 * @param secret  The API secret key
	 */
	protected RestClient(Class<T> mapping, String key, String secret) {
		this.mapping = mapping;
		this.key = key;
		this.secret = secret;
		this.configuration = new RestClientConfiguration();
		service = createService();
	}

	/**
	 * Generates the retrofit service that makes the API calls
	 *
	 * @param prefix The API to make the calls to
	 * @return The service responsible for making calls to the API
	 */
	protected T createService() {
		Converter.Factory converterFactory = JacksonConverterFactory.create();
		Dispatcher dispatcher = new Dispatcher();
		dispatcher.setMaxRequestsPerHost(configuration.getMaxRequestsPerHost());
		dispatcher.setMaxRequests(configuration.getMaxRequests());

		OkHttpClient httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
		AuthenticationInterceptor interceptor = new AuthenticationInterceptor(key, secret);

		String apiUrl = !configuration.useTestnet() ? String.format("https://%s", configuration.getBaseDomain())
				: String.format("https://%s", configuration.getTestnetDomain());

		OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();

		return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
	}

	/**
	 * @return the configuration
	 */
	public RestClientConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * @param configuration the configuration to set
	 */
	public void setConfiguration(RestClientConfiguration configuration) {
		this.configuration = configuration;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}

	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}

	/**
	 * @return the mapping
	 */
	public Class<T> getMapping() {
		return mapping;
	}

	/**
	 * @param mapping the mapping to set
	 */
	public void setMapping(Class<T> mapping) {
		this.mapping = mapping;
	}
}