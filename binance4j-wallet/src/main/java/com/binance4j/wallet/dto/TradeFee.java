package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trading pair trade fees.
 * 
 * @param symbol          The trading pair.
 * @param makerCommission The maker fees (limit order).
 * @param takerCommission The taker fees (market order).
 */
@ApiModel("")
public record TradeFee(@ApiModelProperty("") String symbol, @ApiModelProperty("") String makerCommission, @ApiModelProperty("") String takerCommission) {
}
