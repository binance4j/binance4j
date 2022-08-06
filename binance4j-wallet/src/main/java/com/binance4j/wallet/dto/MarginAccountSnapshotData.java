package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Margin account snapshot data. */
@ApiModel("")
public record MarginAccountSnapshotData(@ApiModelProperty("") String marginLevel, @ApiModelProperty("") String totalAssetOfBtc,
		@ApiModelProperty("") String totalLiabilityOfBtc, @ApiModelProperty("") String totalNetAssetOfBtc,
		@ApiModelProperty("") List<MarginAccountSnapshotUserAssets> userAssetss) {
}