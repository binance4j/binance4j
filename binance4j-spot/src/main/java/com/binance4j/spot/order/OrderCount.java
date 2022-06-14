package com.binance4j.spot.order;

import com.binance4j.core.exchangeinfo.RateLimitInterval;
import com.binance4j.core.exchangeinfo.RateLimitType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * The user's current order count usage for all intervals.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderCount {
	/**
	 * The type of order
	 */
	private RateLimitType rateLimitType;
	/**
	 * The order interval
	 */
	private RateLimitInterval interval;
	/**
	 * The order interval num
	 */
	private Integer intervalNum;
	/**
	 * The order limit
	 */
	private Integer limit;
	/**
	 * The current order count
	 */
	private Integer count;
}