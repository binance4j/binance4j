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
@ApiModel("Hashrate resale detail wrapper.")
data class HashrateResaleDetailResponse(
@ApiModelProperty("Response code.")
var code:int?=null,
@ApiModelProperty("Response message.")
var msg:String?=null,
@ApiModelProperty("Response data.")
var data:HashrateResaleDetailData?=null)
{
}