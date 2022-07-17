package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Details about an asset dust trasnfer (convertion into BNB) */
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
		long tranId,
		/** The transfered amount after fees. */
		BigDecimal transferedAmount) {
}