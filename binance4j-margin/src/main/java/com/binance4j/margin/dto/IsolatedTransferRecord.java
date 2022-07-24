package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An asset transfer record between two accounts.
 * 
 * @param amount        The transfered amount.
 * @param asset         The transfered asset.
 * @param status        The transfer status.
 * @param timestamp     The transfer timestamp in ms.
 * @param transactionId The transaction id.
 * @param transferFrom  The account the asset is transfered from.
 * @param transferTo    The account the asset is transfered to.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTransferRecord(
		/** The transfered amount. */
		BigDecimal amount,
		/** The transfered asset. */
		String asset,
		/** The transfer status. */
		String status,
		/** The transfer timestamp in ms. */
		long timestamp,
		/** The transaction id. */
		@JsonProperty("txId") long transactionId,
		/** The account the asset is transfered from. */
		@JsonProperty("transFrom") IsolatedTransferAccount transferFrom,
		/** The account the asset is transfered to. */
		@JsonProperty("transTo") IsolatedTransferAccount transferTo) {
}