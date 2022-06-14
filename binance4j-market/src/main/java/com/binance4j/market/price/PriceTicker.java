package com.binance4j.market.price;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Wraps a symbol and its corresponding latest price.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PriceTicker {
	/**
	 * Ticker symbol.
	 */
	private String symbol;
	/**
	 * Latest price.
	 */
	private String price;
}
