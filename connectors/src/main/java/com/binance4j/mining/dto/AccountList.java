package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account statistics.
 * 
 * @property time     Time in ms.
 * @property hashrate Hashrate.
 * @property reject   Reject rate.
 */
@ApiModel("Account statistics.")
data class AccountList(
@ApiModelProperty("Time in ms.")
 val time : Long,
@ApiModelProperty("Hashrate.")
 val hashrate : String,
@ApiModelProperty("Reject rate.")
 val reject : String)
{
}
