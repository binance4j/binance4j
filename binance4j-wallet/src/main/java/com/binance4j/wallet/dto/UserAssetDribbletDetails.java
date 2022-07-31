package com.binance4j.wallet.dto;

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
public record UserAssetDribbletDetails(@JsonProperty("transId") long transactionId, long operateTime, String serviceChargeAmount, String amount,
		String transferedAmount, String fromAsset) {
}