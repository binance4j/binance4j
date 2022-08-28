package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin account info.
 * 
 * @property assets              Owned assets.
 * @property totalAssetOfBtc     Total asset of Bitcoin.
 * @property totalLiabilityOfBtc Total liability of Bitcoin.
 * @property totalNetAssetOfBtc  Total net asset of Bitcoin.
 */
@ApiModel("Isolated margin account info.")
data class IsolatedAccount(@ApiModelProperty("Owned assets.") List<IsolatedPair> assets,
		@ApiModelProperty("Total asset of Bitcoin.") var totalAssetOfBtc : String? = null,
		@ApiModelProperty("Total liability of Bitcoin.") var totalLiabilityOfBtc : String? = null,
		@ApiModelProperty("Total net asset of Bitcoin.") var totalNetAssetOfBtc : String? = null) {
}
