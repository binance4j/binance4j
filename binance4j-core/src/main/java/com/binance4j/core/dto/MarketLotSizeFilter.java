package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for MARKET orders on a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MarketLotSizeFilter(
		/** The minimum quantity/icebergQty allowed. */
		BigDecimal minQty,
		/** The maximum quantity/icebergQty allowed. */
		BigDecimal maxQty,
		/**
		 * The intervals that a quantity/icebergQty can be increased/decreased by.
		 */
		BigDecimal stepSize) {
}