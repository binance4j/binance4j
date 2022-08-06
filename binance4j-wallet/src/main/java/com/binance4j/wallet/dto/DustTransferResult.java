package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Details about an asset dust trasnfer (convertion into BNB).
 * 
 * @param amount              The amount of volume converted.
 * @param fromAsset           The converted asset abbreviation.
 * @param operateTime         The operation timestamp.
 * @param serviceChargeAmount The fees.
 * @param tranId              The transaction id.
 * @param transferedAmount    The transfered amount after fees.
 */
@ApiModel("")
public record DustTransferResult(@ApiModelProperty("") String amount, @ApiModelProperty("") String fromAsset, @ApiModelProperty("") long operateTime,
		@ApiModelProperty("") String serviceChargeAmount, @ApiModelProperty("") long tranId, @ApiModelProperty("") String transferedAmount) {
}