package com.binance4j.core.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for a symbol.
 * 
 * @param minQuantity The minimum quantity/iceberg Quantity allowed.
 * @param maxQuantity The maximum quantity/iceberg Quantity allowed.
 * @param stepSize    The intervals that a quantity/iceberg Quantity can be increased/decreased by.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LotSizeFilter(
		/** The minimum quantity/iceberg Quant iuantity allowed. */
		@JsonProperty("minQty") BigDecimal minQuantity,
		/** The maximum quantity/iceberg Quantity allowed. */
		@JsonProperty("maxQty") BigDecimal maxQuantity,
		/** The intervals that a quantity/iceberg Quantity can be increased/decreased by. */
		BigDecimal stepSize) {
}