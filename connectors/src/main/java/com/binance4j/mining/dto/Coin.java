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
 val coinName : String,
@ApiModelProperty("Coin id.")
 val coinId : Long,
@ApiModelProperty("Pool index.")
 val poolIndex : Long,
@ApiModelProperty("Algorithm id.")
 val algoId : Long,
@ApiModelProperty("Name of the algorithm.")
 val algoName : String)
{
}
