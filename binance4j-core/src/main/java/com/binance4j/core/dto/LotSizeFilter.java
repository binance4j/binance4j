package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for a symbol.
 * 
 * @param maxQty   The minimum quantity/icebergQty allowed.
 * @param stepSize The maximum quantity/icebergQty allowed.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a> * @param minQty
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LotSizeFilter(
		/** The minimum quantity/icebergQty allowed. */
		@JsonProperty("minQty") BigDecimal minQuantity,
		/** The maximum quantity/icebergQty allowed. */
		@JsonProperty("maxQty") BigDecimal maxQuantity,
		/** The intervals that a quantity/icebergQty can be increased/decreased by. */
		BigDecimal stepSize) {
}