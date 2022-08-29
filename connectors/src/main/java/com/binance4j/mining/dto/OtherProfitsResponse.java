package com.binance4j.mining.dto;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link MiningClient} response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Other profits wrapper.")
data class OtherProfitsResponse(
@ApiModelProperty("Response code.")
 var code:Int = 0,
@ApiModelProperty("Response message.")
 val msg : String,
@ApiModelProperty("Response data.")
 var data:OtherProfitsData?=null)
{
}