package com.binance4j.margin.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated margin account info.
 * 
 * @param assets              Owned assets.
 * @param totalAssetOfBtc     Total asset of Bitcoin.
 * @param totalLiabilityOfBtc Total liability of Bitcoin.
 * @param totalNetAssetOfBtc  Total net asset of Bitcoin.
 */
@ApiModel("Isolated margin account info.")
public record IsolatedAccount(@ApiModelProperty("Owned assets.") List<IsolatedPair> assets, @ApiModelProperty("Total asset of Bitcoin.") String totalAssetOfBtc,
		@ApiModelProperty("Total liability of Bitcoin.") String totalLiabilityOfBtc,
		@ApiModelProperty("Total net asset of Bitcoin.") String totalNetAssetOfBtc) {
}