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
 val algoName : String,
@ApiModelProperty("Algorithm id.")
 val algoId : Long,
@ApiModelProperty("Sequence.")
 val poolIndex : Long,
@ApiModelProperty("Unit.")
 val unit : String)
{
}
