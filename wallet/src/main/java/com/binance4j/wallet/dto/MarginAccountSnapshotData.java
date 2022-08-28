package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin account snapshot data.
 * 
 * @param marginLevel         Margin level.
 * @param totalAssetOfBtc     Total Asset Of Btc.
 * @param totalLiabilityOfBtc Total Liability Of Btc.
 * @param totalNetAssetOfBtc  Total Net Asset Of Btc.
 * @param userAssets          User Assetss.
 */
@ApiModel("Margin account snapshot data.")
public record MarginAccountSnapshotData(@ApiModelProperty("Margin level.") String marginLevel,
		@ApiModelProperty("Total Asset Of Btc.") String totalAssetOfBtc,
		@ApiModelProperty("Total Liability Of Btc.") String totalLiabilityOfBtc,
		@ApiModelProperty("Total Net Asset Of Btc.") String totalNetAssetOfBtc,
		@ApiModelProperty("User Assetss.") List<MarginAccountSnapshotUserAssets> userAssets) {
}