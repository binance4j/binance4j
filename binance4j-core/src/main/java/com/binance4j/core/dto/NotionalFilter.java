package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Defines the acceptable notional range allowed for an order on a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class NotionalFilter {
	/**
	 * The minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
	 */
	private BigDecimal minNotional;

	/**
	 * The maximum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
	 */
	private BigDecimal maxNotional;

	/** Determines whether the minNotional will be applied to MARKET orders. */
	private Boolean applyMinToMarket;

	/** determines whether the maxNotional will be applied to MARKET orders. */
	private Boolean applyMaxToMarket;

	/**
	 * The number of minutes the average price is calculated over. 0 means the last price is used.
	 */
	private Integer avgPriceMins;
}
