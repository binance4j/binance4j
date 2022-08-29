package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Collaterate rate info.
 * 
 * @property asset          Asset.
 * @property collateralRate Collateral rate.
 */
@ApiModel("Collaterate rate info.")
data class CollaterateRateInfo(
@ApiModelProperty("Asset.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Collateral rate.")
@JsonProperty("collateralRate") var collateralRate: String = "")
{
}