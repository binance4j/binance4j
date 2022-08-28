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
var algoName:String?=null,
@ApiModelProperty("Algorithm id.")
var algoId:Long?=null,
@ApiModelProperty("Sequence.")
var poolIndex:Long?=null,
@ApiModelProperty("Unit.")
var unit:String?=null)
{
}
