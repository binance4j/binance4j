package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for MARKET orders on a symbol.
 * 
 * @param minQuantity The minimum quantity/iceberg quantity allowed.
 * @param maxQuantity The maximum quantity/iceberg quantity allowed.
 * @param stepSize    The intervals that a quantity/iceberg quantity can be increased/decreased by.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MarketLotSizeFilter(
		/** The minimum quantity/iceberg quantity allowed. */
		@JsonProperty("minQty") BigDecimal minQuantity,
		/** The maximum quantity/iceberg quantity allowed. */
		@JsonProperty("maxQty") BigDecimal maxQuantity,
		/** The intervals that a quantity/iceberg quantity can be increased/decreased by. */
		BigDecimal stepSize) {
}