package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getProfits] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Profits wrapper.")
data class ProfitResponse(
@ApiModelProperty("Response code.")
 var code:Int = 0,
@ApiModelProperty("Response message.")
 val msg : String,
@ApiModelProperty("Response data.")
 var data:ProfitsData?=null)
{
}