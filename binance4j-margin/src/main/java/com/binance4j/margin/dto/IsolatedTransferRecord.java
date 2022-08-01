package com.binance4j.margin.dto;

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
 * @see IsolatedTransferAccount
 */
public record IsolatedTransferRecord(String amount, String asset, String status, long timestamp, long txId, String transFrom, String transTo) {
}