package com.binance4j.margin.dto;

/**
 * A symbol price index.
 * 
 * @param calculationTime The last price calculation timestamp in ms.
 * @param price           The price.
 * @param symbol          The asset pair.
 */
public record PriceIndex(long calcTime, String price, String symbol) {
}
