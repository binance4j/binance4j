package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dust log details.
 * 
 * @param transactionId       The transaction id.
 * @param operateTime         The timestamp.
 * @param serviceChargeAmount The fees.
 * @param amount              The volume.
 * @param transferedAmount    The transfered amount.
 * @param fromAsset           The transfered asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserAssetDribbletDetails(
		/** The transaction id. */
		@JsonProperty("transId") long transactionId,
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