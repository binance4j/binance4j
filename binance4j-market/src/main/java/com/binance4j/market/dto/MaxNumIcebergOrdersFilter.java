package com.binance4j.market.dto;

/**
 * Defines the allowed maximum position an account can have on the base asset of a symbol.
 *
 * @param maxNumIcebergOrders Max iceberg orders.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record MaxNumIcebergOrdersFilter(
		/** Max iceberg orders. */
		int maxNumIcebergOrders) {
}