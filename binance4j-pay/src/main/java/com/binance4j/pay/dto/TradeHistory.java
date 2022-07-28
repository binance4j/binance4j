package com.binance4j.pay.dto;

import java.util.List;

/**
 * A pay trade history.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    The trades.
 * @param success Resposne success.
 */
public record TradeHistory(
		/** Response code. */
		String code,
		/** Response message. */
		String message,
		/** The trades. */
		List<Trade> data,
		/** Resposne success. */
		boolean success) {

}
