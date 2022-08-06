package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The dust transfer (asset to BNB) response.
 * 
 * @param totalServiceCharge The fees.
 * @param totalTransfered    The volume converted into BNB after fees.
 * @param transferResult     Detailed transfer result asset by asset.
 */
@ApiModel("")
public record DustTransferResponse(@ApiModelProperty("") String totalServiceCharge, @ApiModelProperty("") String totalTransfered,
		@ApiModelProperty("") List<DustTransferResult> transferResult) {
}