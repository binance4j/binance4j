package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A wallet to wallet transfer */
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
		long tranId,
		/** The transfer timestamp. */
		long timestamp) {
}
