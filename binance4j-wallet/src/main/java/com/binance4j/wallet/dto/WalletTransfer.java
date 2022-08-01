package com.binance4j.wallet.dto;

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
public record WalletTransfer(String asset, String amount,
		/**
		 * The transfer type (origin wallet to destination wallet).
		 * 
		 * @see WalletTransferType
		 */
		String type, String status, long tranId, long timestamp) {
}
