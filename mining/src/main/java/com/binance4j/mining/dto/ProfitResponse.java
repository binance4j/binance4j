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
@JsonProperty("code") var code:int?=null,
@ApiModelProperty("Response message.")
@JsonProperty("msg") var msg:String?=null,
@ApiModelProperty("Response data.")
@JsonProperty("data") var data:ProfitsData?=null)
{
}