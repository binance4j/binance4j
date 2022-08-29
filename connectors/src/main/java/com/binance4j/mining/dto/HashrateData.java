package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate data.
 * 
 * @property time     Time in ms.
 * @property hashrate Hashrate.
 * @property reject   Rejection Rate.
 */
@ApiModel("Hashrate data.")
data class HashrateData(
@ApiModelProperty("Time in ms.")
 val time : Long,
@ApiModelProperty("Hashrate.")
 val hashrate : String,
@ApiModelProperty("Rejection Rate.")  val reject : Long)
{
}