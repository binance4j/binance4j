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
@ApiModel("Position Amount.")
public record PositionAmount(@ApiModelProperty("Amount.") String amount,
		@ApiModelProperty("Amount in BTC.") String amountInBTC,
		@ApiModelProperty("Amount in USDT.") String amountInUSDT, @ApiModelProperty("Asset.") String asset) {
}
