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
		@ApiModelProperty("Margin level.") @JsonProperty("marginLevel ") var marginLevel : String = "",
		@ApiModelProperty("Total asset of Bitcoin.") @JsonProperty("totalAssetOfBtc ") var totalAssetOfBtc : String = "",
		@ApiModelProperty("Total liability of Bitcoin.") @JsonProperty("totalLiabilityOfBtc ") var totalLiabilityOfBtc : String = "",
		@ApiModelProperty("Total net asset of Bitcoin.") @JsonProperty("totalNetAssetOfBtc ") var totalNetAssetOfBtc : String = "",
		@ApiModelProperty("Is borrow enabled?") @JsonProperty("borrowEnabled ") var borrowEnabled : Boolean = false,
		@ApiModelProperty("Is trade enabled?") @JsonProperty("tradeEnabled ") var tradeEnabled : Boolean = false,
		@ApiModelProperty("Is transfer Enabled?") @JsonProperty("transferEnabled ") var transferEnabled : Boolean = false) {
}