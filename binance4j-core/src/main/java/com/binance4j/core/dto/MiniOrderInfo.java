package com.binance4j.core.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Trade order information.
 * 
 * @param symbol        The order symbol.
 * @param orderId       Order id.
 * @param clientOrderId Client order id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MiniOrderInfo(
		/** The order symbol. */
		String symbol,
		/** Order id. */
		Long orderId,
		/** Client order id. */
		String clientOrderId) {
}