package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The user universal transfer response.
 * 
 * @param transactionId The transaction id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WalletTransferResponse(
		/** The transaction id. */
		@JsonProperty("tranId") long transactionId) {
}