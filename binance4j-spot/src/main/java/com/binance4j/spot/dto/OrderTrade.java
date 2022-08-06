package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The partial trade of an order.
 * 
 * @param price           The price.
 * @param qty             The quantity.
 * @param commission      The commission.
 * @param commissionAsset The commission asset.
 * @param tradeId         The trade id.
 */
@ApiModel("")
public record OrderTrade(@ApiModelProperty("") String price, @ApiModelProperty("") String qty, @ApiModelProperty("") String commission,
		@ApiModelProperty("") String commissionAsset, @ApiModelProperty("") long tradeId) {
}
