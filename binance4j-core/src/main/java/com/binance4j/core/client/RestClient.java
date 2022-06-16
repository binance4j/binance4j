package com.binance4j.core.client;

import com.binance4j.core.configuration.RestClientConfiguration;
import com.binance4j.core.security.AuthenticationInterceptor;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * A base client for the Binance API
 *
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#endpoint-security-type">security</a>
 */
@Data
public abstract class RestClient<T> {

    /** The client configuration */
    protected RestClientConfiguration configuration;

    /** The API public key */
    private String key;

    /** The API private key */
    private String secret;

    /** The retrofit API mapping */
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    protected Class<T> mapping;

    /**
     * The current API service
     */
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    protected T service;

    /**
     * The current API prefix
     */
    @Setter(value = AccessLevel.NONE)
    private String prefix;

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
        this.prefix = configuration.getApiPrefixes().get(0);
        service = createService(prefix);
    }

    /**
     * Updates the current prefix for the next in the
     * {@link RestClientConfiguration#apiPrefixes}
     * list or to the first one if we were at the end
     */
    public void next() {
        int index = configuration.getApiPrefixes().indexOf(prefix);
        prefix = configuration.getApiPrefixes()
                .get((index == configuration.getApiPrefixes().size() - 1) ? 0 : index + 1);
    }

    /**
     * Generates the retrofit service that makes the API calls
     *
     * @param prefix The API to make the calls to
     * @return The service responsible for making calls to the API
     */
    protected T createService(String prefix) {
        Converter.Factory converterFactory = JacksonConverterFactory.create();
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.setMaxRequestsPerHost(configuration.getMaxRequestsPerHost());
        dispatcher.setMaxRequests(configuration.getMaxRequests());

        OkHttpClient httpClient = new OkHttpClient.Builder().dispatcher(dispatcher).build();
        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(key, secret);

        String apiUrl = !configuration.useTestnet()
                ? String.format("https://%s.%s", prefix, configuration.getBaseDomain())
                : String.format("https://%s", configuration.getTestnetDomain());

        OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();

        return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build()
                .create(mapping);
    }
}