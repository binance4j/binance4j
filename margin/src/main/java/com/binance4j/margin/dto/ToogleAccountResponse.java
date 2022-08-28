package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response after enabling/disabling isolated margin account.
 * 
 * @property success Was the request a success?
 * @property symbol  Enabled/disabled symbol.
 */
@ApiModel("Response after enabling/disabling isolated margin account.")
data class ToogleAccountResponse(
@ApiModelProperty("Was the request a success?")
var success:Boolean?=null,
@ApiModelProperty("The enabled/disabled symbol.") String symbol)
{
}
