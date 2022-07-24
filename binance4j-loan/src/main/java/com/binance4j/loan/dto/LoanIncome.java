package com.binance4j.loan.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A loan income.
 * 
 * @param asset         The income asset.
 * @param type          The income type.
 * @param amount        The income maount.
 * @param timestamp     The timestamp in ms.
 * @param transactionId The transaction id.
 */
public record LoanIncome(
		/** The income asset. */
		String asset,
		/** The income type. */
		String type,
		/** The income maount. */
		BigDecimal amount,
		/** The timestamp in ms. */
		long timestamp,
		/** The transaction id. */
		@JsonProperty("tranId") String transactionId) {
}