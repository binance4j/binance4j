package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Details about an asset dust trasnfer (convertion into BNB).
 * 
 * @param amount              The amount of volume converted.
 * @param fromAsset           The converted asset abbreviation.
 * @param operateTime         The operation timestamp.
 * @param serviceChargeAmount The fees.
 * @param transactionId       The transaction id.
 * @param transferedAmount    The transfered amount after fees.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DustTransferResult(
		/** The amount of volume converted. */
		BigDecimal amount,
		/** The converted asset abbreviation. */
		String fromAsset,
		/** The operation timestamp. */
		long operateTime,
		/** The fees. */
		BigDecimal serviceChargeAmount,
		/** The transaction id. */
		@JsonProperty("tranId") long transactionId,
		/** The transfered amount after fees. */
		BigDecimal transferedAmount) {
}