package com.binance4j.margin.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data about a repay.
 * 
 * @param transactionId  The transaction id.
 * @param timestamp      The transaction timestamp in ms.
 * @param isolatedSymbol The isolated symbol, will not be returned for crossed margin.
 * @param amount         The total amount repaid.
 * @param asset          The asset.
 * @param interest       The interest repaid.
 * @param principal      The quantity repaid.
 * @param status         The repay status.
 * @see LoanStatus
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RepayRecord(
		/** The transaction id. */
		@JsonProperty("txId") long transactionId,
		/** The transaction timestamp in ms. */
		long timestamp,
		/** The isolated symbol, will not be returned for crossed margin. */
		Optional<String> isolatedSymbol,
		/** The total amount repaid. */
		String amount,
		/** The asset. */
		String asset,
		/** The interest repaid. */
		String interest,
		/** The quantity repaid. */
		String principal,
		/**
		 * The repay status.
		 * 
		 * @see LoanStatus
		 */
		String status) {
}