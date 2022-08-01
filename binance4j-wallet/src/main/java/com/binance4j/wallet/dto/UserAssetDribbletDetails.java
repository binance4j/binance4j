package com.binance4j.wallet.dto;

/**
 * Dust log details.
 * 
 * @param transId             The transaction id.
 * @param operateTime         The timestamp.
 * @param serviceChargeAmount The fees.
 * @param amount              The volume.
 * @param transferedAmount    The transfered amount.
 * @param fromAsset           The transfered asset.
 */
public record UserAssetDribbletDetails(long transId, long operateTime, String serviceChargeAmount, String amount, String transferedAmount, String fromAsset) {
}