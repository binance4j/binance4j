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
	protected String baseDomain = "api.binance.com";
	/** Testnet URL base domain. */
	protected String testnetDomain = "testnet.binance.vision";
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
		String domain = useTestnet ? testnetDomain : baseDomain;
		String apiUrl = String.format("https://%s", domain);
		OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();
		return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build().create(mapping);
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

	/** @return the mapping. */
	public Class<T> getMapping() {
		return mapping;
	}

	/** @param mapping the mapping to set */
	public void setMapping(Class<T> mapping) {
		this.mapping = mapping;
	}

	/**
	 * @return the baseDomain
	 */
	public String getBaseDomain() {
		return baseDomain;
	}

	/**
	 * @param baseDomain the baseDomain to set
	 */
	public void setBaseDomain(String baseDomain) {
		this.baseDomain = baseDomain;
	}

	/**
	 * @return the testnetDomain
	 */
	public String getTestnetDomain() {
		return testnetDomain;
	}

	/**
	 * @param testnetDomain the testnetDomain to set
	 */
	public void setTestnetDomain(String testnetDomain) {
		this.testnetDomain = testnetDomain;
	}

	/**
	 * @return the useTestnet
	 */
	public boolean isUseTestnet() {
		return useTestnet;
	}

	/**
	 * @param useTestnet the useTestnet to set
	 */
	public void setUseTestnet(boolean useTestnet) {
		this.useTestnet = useTestnet;
	}

	/**
	 * @return the mapper
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}

	/**
	 * @param mapper the mapper to set
	 */
	public void setMapper(ObjectMapper mapper) {
		this.mapper = mapper;
	}
}