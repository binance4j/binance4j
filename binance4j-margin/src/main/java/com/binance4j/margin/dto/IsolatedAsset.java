package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated asset in {@link IsolatedPair}.
 * 
 * @param asset         Asset name.
 * @param borrowEnabled Borrowed quantity.
 * @param repayEnabled  Free quantity.
 * @param borrowed      Loan interest.
 * @param free          Locked quantity.
 * @param interest      Net asset quantity.
 * @param locked        Net asset of Bitcoin.
 * @param netAsset      Asset total quantity.
 * @param netAssetOfBtc Can the account borrow this asset?
 * @param totalAsset    Can the account repay this asset?
 */
@ApiModel("Isolated asset in isolated pair.")
public record IsolatedAsset(@ApiModelProperty("Asset name.") String asset,
		@ApiModelProperty("Borrowed quantity.") String borrowed,
		@ApiModelProperty("Free quantity.") String free, @ApiModelProperty("Loan interest.") String interest,
		@ApiModelProperty("Locked quantity.") String locked, @ApiModelProperty("Net asset quantity.") String netAsset,
		@ApiModelProperty("Net asset of Bitcoin.") String netAssetOfBtc,
		@ApiModelProperty("Asset total quantity.") String totalAsset,
		@ApiModelProperty("Can the account borrow this asset?") boolean borrowEnabled,
		@ApiModelProperty("Can the account repay this asset?") boolean repayEnabled) {
}