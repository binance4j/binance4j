package com.binance4j.margin.dto;

import com.binance4j.margin.client.MarginClient;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * BNB burn status after
 * [MarginClient.toggleBNBBurnOnSpotTradeAndMarginInterest]
 * 
 * @property spotBNBBurn     Is spot BNB burn allowed.
 * @property interestBNBBurn Is interest BNB burn allowed.
 */
@ApiModel("BNB burn status")
data class BNBBurnStatus(
@ApiModelProperty("Is spot BNB burn allowed.")
@JsonProperty("spotBNBBurn") var spotBNBBurn: Boolean = false,
@ApiModelProperty("Is interest BNB burn allowed.") @JsonProperty("interestBNBBurn") var interestBNBBurn: Boolean = false)
{
}