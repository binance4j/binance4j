package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Asset that can be converted into BNB.
 * 
 * @param asset            Asset name.
 * @param assetFullName    Asset full name.
 * @param amountFree       Free balance.
 * @param toBTC            BTC valuation.
 * @param toBNB            BNB valuation.
 * @param toBNBOffExchange BNB valuation commissions fees deducted.
 * @param exchange         Commission fees.
 */
@ApiModel("Asset that can be converted into BNB.")
public record ConvertibleAsset(@ApiModelProperty("Asset name.") String asset,
		@ApiModelProperty("Asset full name.") String assetFullName,
		@ApiModelProperty("Free balance.") String amountFree, @ApiModelProperty("BTC valuation.") String toBTC,
		@ApiModelProperty("BNB valuation.") String toBNB,
		@ApiModelProperty("BNB valuation commissions fees deducted.") String toBNBOffExchange,
		@ApiModelProperty("Commission fees.") String exchange) {
}
