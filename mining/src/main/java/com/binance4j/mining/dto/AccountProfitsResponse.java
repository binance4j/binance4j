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
var code:int?=null,
@ApiModelProperty("Response message.")
var msg:String?=null,
@ApiModelProperty("Response data.")
var data:AccountProfitsData?=null)
{
}