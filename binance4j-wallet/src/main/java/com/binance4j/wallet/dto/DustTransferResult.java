package com.binance4j.wallet.dto;

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
public record DustTransferResult(String amount, String fromAsset, long operateTime, String serviceChargeAmount, long tranId, String transferedAmount) {
}