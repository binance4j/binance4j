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
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Borrowed quantity.")
@JsonProperty("borrowed") var borrowed: String = "",
@ApiModelProperty("Free quantity.")
@JsonProperty("free") var free: String = "",
@ApiModelProperty("Borrow interest.")
@JsonProperty("interest") var interest: String = "",
@ApiModelProperty("Locked quantity.")
@JsonProperty("locked") var locked: String = "",
@ApiModelProperty("Net asset.")
@JsonProperty("netAsset") var netAsset: String = "")
{
}