package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A mineable coin.
 * 
 * @property coinName  Currency name.
 * @property coinId    Coin id.
 * @property poolIndex Pool index.
 * @property algoId    Algorithm id.
 * @property algoName  Name of the algorithm.
 */
@ApiModel("A mineable coin.")
data class Coin(
@ApiModelProperty("Currency name.")
var coinName:String?=null,
@ApiModelProperty("Coin id.")
var coinId:Long?=null,
@ApiModelProperty("Pool index.")
var poolIndex:Long?=null,
@ApiModelProperty("Algorithm id.")
var algoId:Long?=null,
@ApiModelProperty("Name of the algorithm.")
var algoName:String?=null)
{
}
