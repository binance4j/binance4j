package com.binance4j.margin.dto;

/**
 * A transfer history record
 * 
 * @param transactionId The transaction id.
 * @param amount        The transfered amount.
 * @param asset         The transfered asset.
 * @param status        The transfer status.
 * @param timestamp     The transaction time in ms.
 * @param type          The transfer history type.
 */
public record TransferRecord(long txId, String amount, String asset, String status, long timestamp,
		/**
		 * The transfer history type.
		 * 
		 * @see TransferRecordType
		 */
		String type) {
}