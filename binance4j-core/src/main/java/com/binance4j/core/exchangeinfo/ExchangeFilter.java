package com.binance4j.core.exchangeinfo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Trading rules of the exchange.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeFilter {
	/**
	 * The filter type
	 */
	private FilterType filterType;
	/**
	 * The filter limit
	 */
	private Integer limit;
}