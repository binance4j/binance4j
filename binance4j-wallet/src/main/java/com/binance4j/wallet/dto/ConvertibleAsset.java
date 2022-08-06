package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Asset that can be converted into BNB.
 * 
 * @param asset            The asset name.
 * @param assetFullName    The asset full name.
 * @param amountFree       The free balance.
 * @param toBTC            The BTC valuation.
 * @param toBNB            The BNB valuation.
 * @param toBNBOffExchange The BNB valuation commissions fees deducted.
 * @param exchange         Commission fees.
 */
@ApiModel("")
public record ConvertibleAsset(@ApiModelProperty("") String asset, @ApiModelProperty("") String assetFullName, @ApiModelProperty("") String amountFree,
		@ApiModelProperty("") String toBTC, @ApiModelProperty("") String toBNB, @ApiModelProperty("") String toBNBOffExchange,
		@ApiModelProperty("") String exchange) {
}
