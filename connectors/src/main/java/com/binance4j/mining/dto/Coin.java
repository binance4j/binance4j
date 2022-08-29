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
@JsonProperty("coinName") var coinName: String = "",
@ApiModelProperty("Coin id.")
@JsonProperty("coinId") var coinId: Long = 0L,
@ApiModelProperty("Pool index.")
@JsonProperty("poolIndex") var poolIndex: Long = 0L,
@ApiModelProperty("Algorithm id.")
@JsonProperty("algoId") var algoId: Long = 0L,
@ApiModelProperty("Name of the algorithm.")
@JsonProperty("algoName") var algoName: String = "")
{
}
