package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Isolated fee data.
 * 
 * @property coin          Related coin.
 * @property dailyInterest Daily interest.
 * @property borrowLimit   Borrow limit.
 */
@ApiModel("Isolated fee data.")
data class IsolatedFeeData(
@ApiModelProperty("Related coin.")
@JsonProperty("coin") var coin:String?=null,
@ApiModelProperty("Daily interest.")
@JsonProperty("dailyInterest") var dailyInterest:String?=null,
@ApiModelProperty("Borrow limit.")
@JsonProperty("borrowLimit") var borrowLimit:String?=null)
{
}