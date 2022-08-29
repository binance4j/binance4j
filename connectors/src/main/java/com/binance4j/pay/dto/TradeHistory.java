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
@JsonProperty("code") var code: String = "",
@ApiModelProperty("Response message.")
@JsonProperty("message") var message: String = "",
@ApiModelProperty("Trades.") List<Trade> data,
@ApiModelProperty("Response success.") @JsonProperty("success") var success: Boolean = false)
{
}
