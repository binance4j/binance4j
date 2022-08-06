package com.binance4j.blvt.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * {@link Token} Basket.
 * 
 * @param symbol        Symbol.
 * @param amount        Amount.
 * @param notionalValue Notional value.
 */
@ApiModel("Token Basket.")
public record Basket(@ApiModelProperty("Symbol.") String symbol, @ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Notional value.") String notionalValue) {
}