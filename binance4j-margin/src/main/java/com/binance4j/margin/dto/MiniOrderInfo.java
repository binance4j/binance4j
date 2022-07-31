package com.binance4j.margin.dto;

/**
 * Trade order information.
 * 
 * @param symbol        The order symbol.
 * @param orderId       Order id.
 * @param clientOrderId Client order id.
 */
public record MiniOrderInfo(String symbol, long orderId, String clientOrderId) {
}