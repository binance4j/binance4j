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
@JsonProperty("time") var time:Long?=null,
@ApiModelProperty("Hashrate.")
@JsonProperty("hashrate") var hashrate:String?=null,
@ApiModelProperty("Rejection Rate.") @JsonProperty("reject") var reject:Long?=null)
{
}