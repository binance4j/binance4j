package com.binance4j.mining.dto;

import java.util.List;

import com.binance4j.mining.client.MiningClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * [MiningClient.getCoins] response.
 * 
 * @property code Response code.
 * @property msg  Response message.
 * @property data Response data.
 */
@ApiModel("Coins wrapper")
data class CoinsResponse(
@ApiModelProperty("Response code.")
@JsonProperty("code") var code: String = "",
@ApiModelProperty("Response message.")
@JsonProperty("msg") var msg: String = "",
@ApiModelProperty("Response data.") List<Coin> data)
{
}