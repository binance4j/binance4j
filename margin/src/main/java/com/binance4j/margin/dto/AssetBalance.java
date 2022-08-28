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
var asset:String?=null,
@ApiModelProperty("Borrowed quantity.")
var borrowed:String?=null,
@ApiModelProperty("Free quantity.")
var free:String?=null,
@ApiModelProperty("Borrow interest.")
var interest:String?=null,
@ApiModelProperty("Locked quantity.")
var locked:String?=null,
@ApiModelProperty("Net asset.")
var netAsset:String?=null)
{
}