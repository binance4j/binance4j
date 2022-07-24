package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An executed trade history item.
 * 
 * @param status         The loan status.
 * @param principal      The borrowed quantity.
 * @param isolatedSymbol The isolated symbol. Will not be returned for crossed margin.
 * @param asset          The related asset.
 * @param timestamp      The loan timestamp in ms.
 * @param transactionId  The transaction id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Loan(
		/** The loan status. */
		LoanStatus status,
		/** The borrowed quantity. */
		BigDecimal principal,
		/** The isolated symbol. Will not be returned for crossed margin */
		Optional<String> isolatedSymbol,
		/** The related asset. */
		String asset,
		/** The loan timestamp in ms. */
		long timestamp,
		/** The transaction id. */
		@JsonProperty("txId") long transactionId) {
}