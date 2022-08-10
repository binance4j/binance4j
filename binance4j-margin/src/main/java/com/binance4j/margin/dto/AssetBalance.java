package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Asset balance of an {@link Account}.
 * 
 * @param asset    Asset name.
 * @param borrowed Borrowed quantity.
 * @param free     Free quantity.
 * @param interest Borrow interest.
 * @param locked   Locked quantity.
 * @param netAsset Net asset.
 */
@ApiModel("Asset balance of an Account.")
public record AssetBalance(@ApiModelProperty("Asset name.") String asset,
		@ApiModelProperty("Borrowed quantity.") String borrowed,
		@ApiModelProperty("Free quantity.") String free, @ApiModelProperty("Borrow interest.") String interest,
		@ApiModelProperty("Locked quantity.") String locked, @ApiModelProperty("Net asset.") String netAsset) {
}