package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pay trade history.
 * 
 * @property code    Response code.
 * @property message Response message.
 * @property data    Trades.
 * @property success Response success.
 */
@ApiModel("Pay trade history.")
data class TradeHistory(
@ApiModelProperty("Response code.")
 val code : String,
@ApiModelProperty("Response message.")
 val message : String,
@ApiModelProperty("Trades.") List<Trade> data,
@ApiModelProperty("Response success.")  val success : Boolean)
{
}
