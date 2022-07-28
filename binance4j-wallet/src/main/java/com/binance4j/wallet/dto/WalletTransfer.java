package com.binance4j.wallet.dto;

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
 * @see WalletTransferType
 */
public record WalletTransfer(
		/** The transfered asset. */
		String asset,
		/** The transfered amount. */
		String amount,
		/**
		 * The transfer type (origin wallet to destination wallet).
		 * 
		 * @see WalletTransferType
		 */
		String type,
		/** The transfer status. */
		String status,
		/** The transaction id. */
		@JsonProperty("tranId") long transactionId,
		/** The transfer timestamp. */
		long timestamp) {
}
