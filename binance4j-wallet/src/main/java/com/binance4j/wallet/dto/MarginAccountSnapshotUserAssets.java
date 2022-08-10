package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin account snapshot user assets.
 * 
 * @param asset    Asset abbreviation.
 * @param borrowed Borrowed amount.
 * @param free     Fee amount.
 * @param interest Interest amount.
 * @param locked   Locked volume.
 * @param netAsset Net asset.
 */
@ApiModel("Margin account snapshot user assets.")
public record MarginAccountSnapshotUserAssets(@ApiModelProperty("Asset abbreviation.") String asset,
		@ApiModelProperty("Borrowed amount.") String borrowed,
		@ApiModelProperty("Fee amount.") String free, @ApiModelProperty("Interest amount.") String interest,
		@ApiModelProperty("Locked volume.") String locked,
		@ApiModelProperty("Net asset.") String netAsset) {
}