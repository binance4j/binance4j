package com.binance4j.core.client;

import com.binance4j.core.dto.TimeInForce;

/** The configuration of every {@link RestClient} */
public class RestClientConfiguration {
	/** URL base domain. */
	private static String defaultBaseDomain = "api.binance.com";
	/** Testnet URL base domain. */
	private static String defaultTestnetDomain = "testnet.binance.vision";
	/** The default order time in force. */
	private static TimeInForce defaultTimeInforce = TimeInForce.GTC;
	/** Max requests per host. */
	private static int defaultMaxRequestsPerHost = 500;
	/** Max requests. */
	private static int defaultMaxRequests = 500;
	/** Defines if the services use the test network. */
	private static boolean defaultUseTestnet = false;
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

	/** @return the defaultBaseDomain */
	public static String getDefaultBaseDomain() {
		return defaultBaseDomain;
	}

	/** @param defaultBaseDomain the defaultBaseDomain to set */
	public static void setDefaultBaseDomain(String defaultBaseDomain) {
		RestClientConfiguration.defaultBaseDomain = defaultBaseDomain;
	}

	/** @return the defaultTestnetDomain */
	public static String getDefaultTestnetDomain() {
		return defaultTestnetDomain;
	}

	/** @param defaultTestnetDomain the defaultTestnetDomain to set */
	public static void setDefaultTestnetDomain(String defaultTestnetDomain) {
		RestClientConfiguration.defaultTestnetDomain = defaultTestnetDomain;
	}

	/** @return the defaultTimeInforce */
	public static TimeInForce getDefaultTimeInforce() {
		return defaultTimeInforce;
	}

	/** @param defaultTimeInforce the defaultTimeInforce to set */
	public static void setDefaultTimeInforce(TimeInForce defaultTimeInforce) {
		RestClientConfiguration.defaultTimeInforce = defaultTimeInforce;
	}

	/** @return the defaultMaxRequestsPerHost */
	public static int getDefaultMaxRequestsPerHost() {
		return defaultMaxRequestsPerHost;
	}

	/** @param defaultMaxRequestsPerHost the defaultMaxRequestsPerHost to set */
	public static void setDefaultMaxRequestsPerHost(int defaultMaxRequestsPerHost) {
		RestClientConfiguration.defaultMaxRequestsPerHost = defaultMaxRequestsPerHost;
	}

	/** @return the defaultMaxRequests */
	public static int getDefaultMaxRequests() {
		return defaultMaxRequests;
	}

	/** @param defaultMaxRequests the defaultMaxRequests to set */
	public static void setDefaultMaxRequests(int defaultMaxRequests) {
		RestClientConfiguration.defaultMaxRequests = defaultMaxRequests;
	}

	/** @return the defaultUseTestnet */
	public static boolean isDefaultUseTestnet() {
		return defaultUseTestnet;
	}

	/** @param defaultUseTestnet the defaultUseTestnet to set */
	public static void setDefaultUseTestnet(boolean defaultUseTestnet) {
		RestClientConfiguration.defaultUseTestnet = defaultUseTestnet;
	}

	/** @return the BaseDomain */
	public String getBaseDomain() {
		return baseDomain;
	}

	/** @param baseDomain the BaseDomain to set */
	public void setBaseDomain(String baseDomain) {
		this.baseDomain = baseDomain;
	}

	/** @return the TestnetDomain */
	public String getTestnetDomain() {
		return testnetDomain;
	}

	/** @param testnetDomain the TestnetDomain to set */
	public void setTestnetDomain(String testnetDomain) {
		this.testnetDomain = testnetDomain;
	}

	/**
	 * @return the timeInForce
	 */
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}

	/**
	 * @param timeInForce the timeInForce to set
	 */
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}

	/** @return the MaxRequestsPerHost */
	public int getMaxRequestsPerHost() {
		return maxRequestsPerHost;
	}

	/** @param maxRequestsPerHost the MaxRequestsPerHost to set */
	public void setMaxRequestsPerHost(int maxRequestsPerHost) {
		this.maxRequestsPerHost = maxRequestsPerHost;
	}

	/** @return the MaxRequests */
	public int getMaxRequests() {
		return maxRequests;
	}

	/** @param maxRequests the MaxRequests to set */
	public void setMaxRequests(int maxRequests) {
		this.maxRequests = maxRequests;
	}

	/** @return the UseTestnet */
	public boolean useTestnet() {
		return useTestnet;
	}

	/** @param useTestnet the UseTestnet to set */
	public void useTestnet(boolean useTestnet) {
		this.useTestnet = useTestnet;
	}
}
