package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Response after enabling/disabling isolated margin account.
 * 
 * @param success Was the request a success?
 * @param symbol  Enabled/disabled symbol.
 */
@ApiModel("Response after enabling/disabling isolated margin account.")
public record ToogleAccountResponse(@ApiModelProperty("Was the request a success?") boolean success,
		@ApiModelProperty("The enabled/disabled symbol.") String symbol) {
}
