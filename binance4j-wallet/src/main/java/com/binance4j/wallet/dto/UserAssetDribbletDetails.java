package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel("")
public record UserAssetDribbletDetails(@ApiModelProperty("") long transId, @ApiModelProperty("") long operateTime,
		@ApiModelProperty("") String serviceChargeAmount, @ApiModelProperty("") String amount, @ApiModelProperty("") String transferedAmount,
		@ApiModelProperty("") String fromAsset) {
}