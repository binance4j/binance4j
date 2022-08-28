package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The dust transfer (asset to BNB) response.
 * 
 * @param totalServiceCharge Fees.
 * @param totalTransfered    Volume converted into BNB after fees.
 * @param transferResult     Detailed transfer result asset by asset.
 */
@ApiModel("The dust transfer (asset to BNB) response.")
public record DustTransferResponse(@ApiModelProperty("Fees.") String totalServiceCharge,
		@ApiModelProperty("Volume converted into BNB after fees.") String totalTransfered,
		@ApiModelProperty("Detailed transfer result asset by asset.") List<DustTransferResult> transferResult) {
}