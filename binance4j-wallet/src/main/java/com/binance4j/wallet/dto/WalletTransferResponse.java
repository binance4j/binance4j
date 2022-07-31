package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The user universal transfer response.
 * 
 * @param transactionId The transaction id.
 */
public record WalletTransferResponse(@JsonProperty("tranId") long transactionId) {
}