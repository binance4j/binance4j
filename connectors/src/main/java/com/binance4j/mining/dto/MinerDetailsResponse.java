package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getMinersDetails] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Miners detail wrapper.")
data class MinerDetailsResponse(
@ApiModelProperty("Response code.")
@JsonProperty("code") var code:int?=null,
@ApiModelProperty("Response message.")
@JsonProperty("msg") var msg:String?=null,
@ApiModelProperty("Response data.") List<MinerDetails> data)
{
}