package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the acceptable notional range allowed for an order on a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NotionalFilter(
		/**
		 * The minimum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
		 */
		BigDecimal minNotional,
		/**
		 * The maximum notional value allowed for an order on a symbol. An order's notional value is the price * quantity.
		 */
		BigDecimal maxNotional,
		/** Determines whether the minNotional will be applied to MARKET orders. */
		Boolean applyMinToMarket,
		/** determines whether the maxNotional will be applied to MARKET orders. */
		Boolean applyMaxToMarket,
		/**
		 * The number of minutes the average price is calculated over. 0 means the last price is used.
		 */
		Integer avgPriceMins) {
}