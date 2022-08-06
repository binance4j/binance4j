package com.binance4j.savings.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Position Amount.
 * 
 * @param amount       Amount.
 * @param amountInBTC  Amount in BTC.
 * @param amountInUSDT Amount in USDT.
 * @param asset        Asset.
 */
@ApiModel("")
public record PositionAmount(@ApiModelProperty("") String amount, @ApiModelProperty("") String amountInBTC, @ApiModelProperty("") String amountInUSDT,
		@ApiModelProperty("") String asset) {
}
