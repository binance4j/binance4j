package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The authenticated margin account.
 * 
 * @property userAssets          User assets.
 * @property marginLevel         Margin level.
 * @property totalAssetOfBtc     Total asset of Bitcoin.
 * @property totalLiabilityOfBtc Total liability of Bitcoin.
 * @property totalNetAssetOfBtc  Total net asset of Bitcoin.
 * @property borrowEnabled       Is borrow enabled?
 * @property tradeEnabled        Is trade enabled?
 * @property transferEnabled     Is transfer Enabled?
 */
@ApiModel("The authenticated margin account.")
data class Account(@ApiModelProperty("User assets.") List<AssetBalance> userAssets,
		@ApiModelProperty("Margin level.") var marginLevel : String? = null,
		@ApiModelProperty("Total asset of Bitcoin.") var totalAssetOfBtc : String? = null,
		@ApiModelProperty("Total liability of Bitcoin.") var totalLiabilityOfBtc : String? = null,
		@ApiModelProperty("Total net asset of Bitcoin.") var totalNetAssetOfBtc : String? = null,
		@ApiModelProperty("Is borrow enabled?") var borrowEnabled : Boolean? = null,
		@ApiModelProperty("Is trade enabled?") var tradeEnabled : Boolean? = null,
		@ApiModelProperty("Is transfer Enabled?") var transferEnabled : Boolean? = null) {
}