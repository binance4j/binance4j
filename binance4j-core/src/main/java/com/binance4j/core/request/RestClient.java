package com.binance4j.core.request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.binance4j.core.misc.TimeInForce;
import com.binance4j.core.security.AuthenticationInterceptor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.QueryMap;

/**
 * A base client for the Binance API
 *
 * @see <a href=
 *      "https://binance-docs.github.io/apidocs/spot/en/#endpoint-security-type">security</a>
 */
@Data
public abstract class RestClient<T> {
    /**
     * The different available api prefixes
     */
    @Getter
    @Setter
    private static List<String> apiPrefixes = new ArrayList<>(List.of("api", "api1", "api2", "api3"));

    /**
     * URL base domain
     */
    @Getter
    @Setter
    private static String baseDomain = "binance.com";
    /**
     * testnet URL base domain
     */
    @Getter
    @Setter
    private static String testnetDomain = "testnet.binance.vision";

    /**
     * The default order time in force
     */
    @Getter
    @Setter
    private static TimeInForce timeInForce = TimeInForce.GTC;

    /**
     * The max requests per host
     */
    @Getter
    @Setter
    private static int maxRequestsPerHost = 500;
    /**
     * The max requests
     */
    @Getter
    @Setter
    private static int maxRequests = 500;

    /**
     * All the API services
     */
    private List<T> services;
    /**
     * Defines if the services use the TestNet API
     */
    private boolean useTestnet;
    /**
     * The API public key
     */
    private String key;
    /**
     * The API private key
     */
    private String secret;
    /**
     * The retrofit API mapping
     */
    protected Class<T> mapping;
    /**
     * Jackson object mapper used to convert a POJO into a {@link QueryMap}
     */
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Instantiates a client for the corresponding mapping
     *
     * @param mapping    The retrofit Service mapping interface
     * @param key        The API public key
     * @param secret     The API secret key
     * @param useTestnet Are we using TestNet?
     */
    protected RestClient(Class<T> mapping, String key, String secret, boolean useTestnet) {
        this.mapping = mapping;
        this.key = key;
        this.secret = secret;
        this.useTestnet = useTestnet;
        reloadServices();
    }

    /**
     * Retrieves prefixes from configuration and generate the api services for the
     * client
     */
    public void reloadServices() {
        services = new ArrayList<>(getApiPrefixes().stream().map(this::createService).toList());
    }

    /**
     * Instantiates a client for the corresponding mapping
     *
     * @param mapping The retrofit Service mapping interface
     * @param key     The API public key
     * @param secret  The API secret key
     */
    protected RestClient(Class<T> mapping, String key, String secret) {
        this(mapping, key, secret, false);
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
        dispatcher.setMaxRequestsPerHost(getMaxRequestsPerHost());
        dispatcher.setMaxRequests(getMaxRequests());

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .dispatcher(dispatcher)
                .build();

        AuthenticationInterceptor interceptor = new AuthenticationInterceptor(
                key,
                secret);

        String apiUrl = !useTestnet
                ? String.format("https://%s.%s", prefix, getBaseDomain())
                : String.format("https://%s", getTestnetDomain());

        OkHttpClient client = httpClient.newBuilder().addInterceptor(interceptor).build();

        return new Retrofit.Builder().baseUrl(apiUrl).addConverterFactory(converterFactory).client(client).build()
                .create(mapping);
    }

    /**
     * Converts a POJO to a Map with no null value
     *
     * @param pojo The Object to convert into a map
     * @return The generated {@link QueryMap}
     */
    protected Map<String, Object> pojoToMap(Object pojo) {
        Map<String, Object> map = mapper.convertValue(
                pojo,
                new TypeReference<Map<String, Object>>() {
                });
        // Removing null and useless parameters from the query map before passing it to
        // the API
        map.remove("weight");
        map.remove("isOrderRequest");
        map.values().removeAll(Collections.singleton(null));
        return map;
    }
}