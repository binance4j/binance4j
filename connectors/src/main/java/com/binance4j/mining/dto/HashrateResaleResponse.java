package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.resellHashrate] response.
 * 
 * @property code Code.
 * @property msg  Message.
 * @property data Mining account.
 */
@ApiModel("Hashrate resale wrapper")
data class HashrateResaleResponse(
@ApiModelProperty("Code.")
 var code:Int = 0,
@ApiModelProperty("Message.")
 val msg : String,
@ApiModelProperty("Mining account.")  var data:Int = 0)
{
}
