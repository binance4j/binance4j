package com.binance4j.c2c.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * C2C trades history.
 * 
 * @param code    Code.
 * @param message Message.
 * @param data    Trades.
 * @param total   Total.
 * @param success Success.
 */
@ApiModel("C2C trades history.")
public record TradeHistory(@ApiModelProperty("Code.") String code, @ApiModelProperty("Message.") String message, @ApiModelProperty("Trades.") List<Trade> data,
		@ApiModelProperty("Total.") int total, @ApiModelProperty("Success.") boolean success) {
}
