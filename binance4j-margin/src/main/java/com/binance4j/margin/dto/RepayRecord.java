package com.binance4j.margin.dto;

import java.util.Optional;

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
public record RepayRecord(long txId, long timestamp, Optional<String> isolatedSymbol, String amount, String asset, String interest, String principal,
		/**
		 * The repay status.
		 * 
		 * @see LoanStatus
		 */
		String status) {
}