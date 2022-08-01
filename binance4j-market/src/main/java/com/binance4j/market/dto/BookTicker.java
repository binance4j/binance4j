package com.binance4j.market.dto;

/**
 * Represents the best price/quantity on the order book for a given symbol.
 * 
 * @param symbol      Ticker symbol.
 * @param bidPrice    Bid price.
 * @param bidQuantity Bid quantity.
 * @param askPrice    Ask price.
 * @param askQuantity Ask quantity.
 */
public record BookTicker(String symbol, String bidPrice, String bidQty, String askPrice, String askQty) {
}