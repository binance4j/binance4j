package com.binance4j.spot.dto;

/**
 * OCO infos.
 * 
 * @param symbol        symbol.
 * @param orderId       order id.
 * @param clientOrderId client order id.
 */
public record OCOOrder(String symbol, long orderId, String clientOrderId) {
}
