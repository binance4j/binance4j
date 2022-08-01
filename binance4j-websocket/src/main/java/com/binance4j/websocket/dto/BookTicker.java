package com.binance4j.websocket.dto;

/**
 * BookTickerEvent event for a symbol. Pushes any update to the best bid or ask price or quantity in real-time for a
 * specified symbol.
 * 
 * @param updateId    The update id.
 * @param symbol      The trading pair.
 * @param bidPrice    The bid price.
 * @param bidQuantity The bid quantity.
 * @param askPrice    The ask price.
 * @param askQuantity The ask quantity.
 */
public record BookTicker(Long u, String s, String b, String B, String a, String A) {
}