package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * A request rate limit for the Binance API defined by a type and an interval
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RateLimit {
	/**
	 * The rate limit type
	 */
	private RateLimitType rateLimitType;
	/**
	 * The limit interval type
	 */
	private RateLimitInterval interval;
	/**
	 * The limit interval number
	 */
	private Integer intervalNum;
	/**
	 * The limit for the given interval
	 */
	private Integer limit;
}