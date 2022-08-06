package com.binance4j.pay.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A pay trade history.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    The trades.
 * @param success Resposne success.
 */
@ApiModel("")
public record TradeHistory(@ApiModelProperty("") String code, @ApiModelProperty("") String message, @ApiModelProperty("") List<Trade> data,
		@ApiModelProperty("") boolean success) {
}
