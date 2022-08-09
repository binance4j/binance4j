package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The partial trade of an order.
 * 
 * @param stopPrice       Price.
 * @param qty             Quantity.
 * @param commission      Commission.
 * @param commissionAsset Commission asset.
 * @param tradeId         Trade id.
 */
@ApiModel("The partial trade of an order.")
public record OrderTrade(@ApiModelProperty("Price.") String price, @ApiModelProperty("Quantity.") String qty,
		@ApiModelProperty("Commission.") String commission,
		@ApiModelProperty("Commission asset.") String commissionAsset,
		@ApiModelProperty("Trade id.") long tradeId) {
}
