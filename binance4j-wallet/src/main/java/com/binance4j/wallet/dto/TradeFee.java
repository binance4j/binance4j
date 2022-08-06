package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trading pair trade fees.
 * 
 * @param symbol          Trading pair.
 * @param makerCommission Maker fees (limit order).
 * @param takerCommission Taker fees (market order).
 */
@ApiModel("A trading pair trade fees.")
public record TradeFee(@ApiModelProperty("Trading pair.") String symbol, @ApiModelProperty("Maker fees (limit order).") String makerCommission,
		@ApiModelProperty("Taker fees (market order).") String takerCommission) {
}
