package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Lending interest.
 * 
 * @property asset       Asset.
 * @property interest    Interest.
 * @property lendingType LendingType.
 * @property productName ProductName.
 * @property time        Time in ms.
 */
@ApiModel("Lending interest.")
data class Interest(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset:String?=null,
@ApiModelProperty("Interest.")
@JsonProperty("interest") var interest:String?=null,
@ApiModelProperty("LendingType.")
@JsonProperty("lendingType") var lendingType:String?=null,
@ApiModelProperty("ProductName.")
@JsonProperty("productName") var productName:String?=null,
@ApiModelProperty("Time in ms.") @JsonProperty("time") var time:Long?=null)
{
}