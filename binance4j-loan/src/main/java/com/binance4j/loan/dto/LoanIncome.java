package com.binance4j.loan.dto;

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
public record LoanIncome(String asset, String type, String amount, long timestamp, @JsonProperty("tranId") String transactionId) {
}