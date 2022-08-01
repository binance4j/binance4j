package com.binance4j.loan.dto;

/**
 * A loan income.
 * 
 * @param asset         The income asset.
 * @param type          The income type.
 * @param amount        The income maount.
 * @param timestamp     The timestamp in ms.
 * @param transactionId The transaction id.
 */
public record LoanIncome(String asset, String type, String amount, long timestamp, String tranId) {
}