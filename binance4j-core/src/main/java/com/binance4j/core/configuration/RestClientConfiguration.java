package com.binance4j.core.configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.binance4j.core.misc.TimeInForce;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RestClientConfiguration {

    /** Available APIs defined by their prefix. */
    @Getter
    @Setter
    private static List<String> defaultApiPrefixes = new ArrayList<>(
            Arrays.asList("api", "api1", "api2", "api3"));

    /** URL base domain. */
    @Getter
    @Setter
    private static String defaultBaseDomain = "binance.com";

    /** Testnet URL base domain. */
    @Getter
    @Setter
    private static String defaultTestnetDomain = "testnet.binance.vision";

    /** The default order time in force. */
    @Getter
    @Setter
    private static TimeInForce defaultTimeInforce = TimeInForce.GTC;

    /** Max requests per host. */
    @Getter
    @Setter
    private static int defaultMaxRequestsPerHost = 500;

    /** Max requests. */
    @Getter
    @Setter
    private static int defaultMaxRequests = 500;

    /** Defines if the services use the test network. */
    @Getter
    @Setter
    private static boolean defaultUseTestnet = false;

    /** Available APIs defined by their prefix. */
    private List<String> apiPrefixes = defaultApiPrefixes;

    /** URL base domain. */
    private String baseDomain = defaultBaseDomain;

    /** Testnet URL base domain. */
    private String testnetDomain = defaultTestnetDomain;

    /** The default order time in force. */
    private TimeInForce timeInForce = defaultTimeInforce;

    /** Max requests per host. */
    private int maxRequestsPerHost = defaultMaxRequestsPerHost;

    /** Max requests. */
    private int maxRequests = defaultMaxRequests;

    /** Defines if the services use the test network. */
    private boolean useTestnet = defaultUseTestnet;

    public void useTestnet(boolean useTestnet) {
        this.useTestnet = useTestnet;
    }

    public boolean useTestnet() {
        return useTestnet;
    }
}
