package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getAlgorithms] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Algorithms wrapper")
data class AlgorithmsResponse(
@ApiModelProperty("Response code.")
@JsonProperty("code") var code:Int = 0,
@ApiModelProperty("Response message.")
@JsonProperty("msg") var msg: String = "",
@ApiModelProperty("Response data.") List<Algorithm> data)
{
}