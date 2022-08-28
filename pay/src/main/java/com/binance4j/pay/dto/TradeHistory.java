package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Pay trade history.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    Trades.
 * @param success Response success.
 */
@ApiModel("Pay trade history.")
public record TradeHistory(@ApiModelProperty("Response code.") String code,
		@ApiModelProperty("Response message.") String message,
		@ApiModelProperty("Trades.") List<Trade> data, @ApiModelProperty("Response success.") boolean success) {
}
