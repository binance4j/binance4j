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
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Interest.")
@JsonProperty("interest") var interest: String = "",
@ApiModelProperty("LendingType.")
@JsonProperty("lendingType") var lendingType: String = "",
@ApiModelProperty("ProductName.")
@JsonProperty("productName") var productName: String = "",
@ApiModelProperty("Time in ms.") @JsonProperty("time") var time: Long = 0L)
{
}