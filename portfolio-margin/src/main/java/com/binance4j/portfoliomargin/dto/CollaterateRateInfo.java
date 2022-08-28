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
var asset:String?=null,
@ApiModelProperty("Collateral rate.")
var collateralRate:String?=null)
{
}