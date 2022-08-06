package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated margin account.
 * 
 * @param userAssets          User assets.
 * @param marginLevel         Margin level.
 * @param totalAssetOfBtc     Total asset of Bitcoin.
 * @param totalLiabilityOfBtc Total liability of Bitcoin.
 * @param totalNetAssetOfBtc  Total net asset of Bitcoin.
 * @param borrowEnabled       Is borrow enabled?
 * @param tradeEnabled        Is trade enabled?
 * @param transferEnabled     Is transfer Enabled?
 */
@ApiModel("The authenticated margin account.")
public record Account(@ApiModelProperty("User assets.") List<AssetBalance> userAssets, @ApiModelProperty("Margin level.") String marginLevel,
		@ApiModelProperty("Total asset of Bitcoin.") String totalAssetOfBtc, @ApiModelProperty("Total liability of Bitcoin.") String totalLiabilityOfBtc,
		@ApiModelProperty("Total net asset of Bitcoin.") String totalNetAssetOfBtc, @ApiModelProperty("Is borrow enabled?") boolean borrowEnabled,
		@ApiModelProperty("Is trade enabled?") boolean tradeEnabled, @ApiModelProperty("Is transfer Enabled?") boolean transferEnabled) {
}