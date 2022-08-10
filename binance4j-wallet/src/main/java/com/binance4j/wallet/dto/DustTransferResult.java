package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details about an asset dust trasnfer (convertion into BNB).
 * 
 * @param amount              Amount of volume converted.
 * @param fromAsset           Converted asset abbreviation.
 * @param operateTime         Operation timestamp.
 * @param serviceChargeAmount Fees.
 * @param tranId              Transaction id.
 * @param transferedAmount    Transfered amount after fees.
 */
@ApiModel("Details about an asset dust trasnfer (convertion into BNB).")
public record DustTransferResult(@ApiModelProperty("Amount of volume converted.") String amount,
		@ApiModelProperty("Converted asset abbreviation.") String fromAsset,
		@ApiModelProperty("Operation timestamp.") long operateTime,
		@ApiModelProperty("Fees.") String serviceChargeAmount, @ApiModelProperty("Transaction id.") long tranId,
		@ApiModelProperty("Transfered amount after fees.") String transferedAmount) {
}