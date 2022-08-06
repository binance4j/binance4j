package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Dust log details.
 * 
 * @param transId             Transaction id.
 * @param operateTime         Timestamp.
 * @param serviceChargeAmount Fees.
 * @param amount              Volume.
 * @param transferedAmount    Transfered amount.
 * @param fromAsset           Transfered asset.
 */
@ApiModel("Dust log details.")
public record UserAssetDribbletDetails(@ApiModelProperty("Transaction id.") long transId, @ApiModelProperty("Timestamp.") long operateTime,
		@ApiModelProperty("Fees.") String serviceChargeAmount, @ApiModelProperty("Volume.") String amount,
		@ApiModelProperty("Transfered amount.") String transferedAmount, @ApiModelProperty("Transfered asset.") String fromAsset) {
}