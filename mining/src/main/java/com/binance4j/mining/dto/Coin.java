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
@JsonProperty("coinName") var coinName:String?=null,
@ApiModelProperty("Coin id.")
@JsonProperty("coinId") var coinId:Long?=null,
@ApiModelProperty("Pool index.")
@JsonProperty("poolIndex") var poolIndex:Long?=null,
@ApiModelProperty("Algorithm id.")
@JsonProperty("algoId") var algoId:Long?=null,
@ApiModelProperty("Name of the algorithm.")
@JsonProperty("algoName") var algoName:String?=null)
{
}
