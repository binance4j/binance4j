package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Assets that can be converted into BNB.
 * 
 * @param details            Details.
 * @param totalTransferBtc   BTC valuation.
 * @param totalTransferBNB   BNB valuation.
 * @param dribbletPercentage Commission fee.
 */
@ApiModel("Assets that can be converted into BNB.")
public record ConvertibleAssets(@ApiModelProperty("Details.") List<ConvertibleAsset> details, @ApiModelProperty("BTC valuation.") String totalTransferBtc,
		@ApiModelProperty("BNB valuation.") String totalTransferBNB, @ApiModelProperty("Commission fee.") String dribbletPercentage) {
}
