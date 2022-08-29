package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getAccountProfits] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Account profits wrapper.")
data class AccountProfitsResponse(
@ApiModelProperty("Response code.")
@JsonProperty("code") var code:Int = 0,
@ApiModelProperty("Response message.")
@JsonProperty("msg") var msg: String = "",
@ApiModelProperty("Response data.")
@JsonProperty("data") var data:AccountProfitsData?=null)
{
}