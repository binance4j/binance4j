package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Dust log details */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DustLogUserAssetDribbletDetails(
		/** The transaction id. */
		long transId,
		/** The timestamp. */
		long operateTime,
		/** The fees. */
		BigDecimal serviceChargeAmount,
		/** The volume. */
		BigDecimal amount,
		/** The transfered amount. */
		BigDecimal transferedAmount,
		/** The transfered asset. */
		String fromAsset) {
}