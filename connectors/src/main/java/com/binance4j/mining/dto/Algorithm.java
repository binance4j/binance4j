package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A mining algorithm.
 * 
 * @property algoName  Algorithm name.
 * @property algoId    Algorithm id.
 * @property poolIndex Sequence.
 * @property unit      Unit.
 */
@ApiModel("A mining algorithm.")
data class Algorithm(
@ApiModelProperty("Algorithm name.")
@JsonProperty("algoName") var algoName: String = "",
@ApiModelProperty("Algorithm id.")
@JsonProperty("algoId") var algoId: Long = 0L,
@ApiModelProperty("Sequence.")
@JsonProperty("poolIndex") var poolIndex: Long = 0L,
@ApiModelProperty("Unit.")
@JsonProperty("unit") var unit: String = "")
{
}
