package com.binance4j.fiat.dto;

import java.util.List;

/**
 * Transaction history.
 * 
 * @param code    Code.
 * @param message Message.
 * @param data    Transactions.
 * @param total   Total.
 * @param success Success.
 */
public record PaymentHistory(
		/** Code. */
		String code,
		/** Message. */
		String message,
		/** Transactions. */
		List<Payment> data,
		/** Total. */
		int total,
		/** Success. */
		boolean success) {

}
