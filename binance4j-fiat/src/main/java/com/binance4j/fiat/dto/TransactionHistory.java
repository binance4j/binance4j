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
public record TransactionHistory(
		/** Code. */
		String code,
		/** Message. */
		String message,
		/** Transactions. */
		List<Transaction> data,
		/** Total. */
		int total,
		/** Success. */
		boolean success) {

}
