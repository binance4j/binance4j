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
 var code:Int = 0,
@ApiModelProperty("Response message.")
 val msg : String,
@ApiModelProperty("Response data.") List<MinerDetails> data)
{
}