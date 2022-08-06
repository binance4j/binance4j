package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Assets that can be converted into BNB.
 * 
 * @param details            Details.
 * @param totalTransferBtc   The BTC valuation.
 * @param totalTransferBNB   The BNB valuation.
 * @param dribbletPercentage The commission fee.
 */
@ApiModel("")
public record ConvertibleAssets(@ApiModelProperty("") List<ConvertibleAsset> details, @ApiModelProperty("") String totalTransferBtc,
		@ApiModelProperty("") String totalTransferBNB, @ApiModelProperty("") String dribbletPercentage) {
}
