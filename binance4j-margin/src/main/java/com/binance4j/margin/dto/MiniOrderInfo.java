package com.binance4j.margin.dto;

/**
 * Trade order information.
 * 
 * @param symbol        The order symbol.
 * @param orderId       Order id.
 * @param clientOrderId Client order id.
 */
public record MiniOrderInfo(
		/** The order symbol. */
		String symbol,
		/** Order id. */
		long orderId,
		/** Client order id. */
		String clientOrderId) {
}