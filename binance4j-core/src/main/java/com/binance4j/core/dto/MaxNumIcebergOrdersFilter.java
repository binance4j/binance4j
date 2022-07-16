package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Defines the allowed maximum position an account can have on the base asset of a symbol.
 * 
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MaxNumIcebergOrdersFilter(
	/** Max iceberg orders. */
		Integer maxNumIcebergOrders) {
}