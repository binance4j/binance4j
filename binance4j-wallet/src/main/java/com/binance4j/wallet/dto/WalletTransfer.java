package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A wallet to wallet transfer.
 * 
 * @param asset         The transfered asset.
 * @param amount        The transfered amount.
 * @param type          The transfer type (origin wallet to destination wallet).
 * @param status        The transfer status.
 * @param transactionId The transaction id.
 * @param timestamp     The transfer timestamp.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WalletTransfer(
		/** The transfered asset. */
		String asset,
		/** The transfered amount. */
		BigDecimal amount,
		/** The transfer type (origin wallet to destination wallet). */
		WalletTransferType type,
		/** The transfer status. */
		String status,
		/** The transaction id. */
		@JsonProperty("tranId") long transactionId,
		/** The transfer timestamp. */
		long timestamp) {
}
