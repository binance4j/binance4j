package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Asset balance of an {@link Account}.
 * 
 * @property asset    Asset name.
 * @property borrowed Borrowed quantity.
 * @property free     Free quantity.
 * @property interest Borrow interest.
 * @property locked   Locked quantity.
 * @property netAsset Net asset.
 */
@ApiModel("Asset balance of an Account.")
data class AssetBalance(
@ApiModelProperty("Asset name.")
 val asset : String,
@ApiModelProperty("Borrowed quantity.")
 val borrowed : String,
@ApiModelProperty("Free quantity.")
 val free : String,
@ApiModelProperty("Borrow interest.")
 val interest : String,
@ApiModelProperty("Locked quantity.")
 val locked : String,
@ApiModelProperty("Net asset.")
 val netAsset : String)
{
}