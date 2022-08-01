package com.binance4j.market.dto;

/**
 * Defines the quantity (aka "lots" in auction terms) rules for MARKET orders on a symbol.
 * 
 * @param minQty   The minimum quantity/iceberg quantity allowed.
 * @param maxQty   The maximum quantity/iceberg quantity allowed.
 * @param stepSize The intervals that a quantity/iceberg quantity can be increased/decreased by.
 * @see <a href= "https://binance-docs.github.io/apidocs/spot/en/#filters">Documentation</a>
 */
public record MarketLotSizeFilter(String minQty, String maxQty, String stepSize) {
}