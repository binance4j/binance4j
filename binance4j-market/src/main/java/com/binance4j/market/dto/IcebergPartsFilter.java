package com.binance4j.market.dto;

/**
 * Defines the maximum parts an iceberg order can have. The number of Iceberg parts is defined as CEIL(qty/icebergQty).
 * 
 * @param limit The filter limit number.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record IcebergPartsFilter(int limit) {
}