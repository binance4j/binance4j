package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An executed trade.
 * 
 * @param id              Trade id.
 * @param price           Price.
 * @param qty             Quantity.
 * @param quoteQty        Quote quantity for the trade (price * qty).
 * @param commission      Commission.
 * @param commissionAsset Asset on which commission is taken.
 * @param time            Trade execution time.
 * @param symbol          Symbol of the trade.
 * @param orderId         Order id.
 * @param orderListId     Order list id.
 * @param isBuyer         Is buyer trade.
 * @param isMaker         Is maker trade.
 * @param isBestMatch     Is best match?
 */
@ApiModel("An executed trade.")
public record Trade(@ApiModelProperty("Trade id.") long id, @ApiModelProperty("Price.") String price, @ApiModelProperty("Quantity.") String qty,
		@ApiModelProperty("Quote quantity for the trade (price * qty).") String quoteQty, @ApiModelProperty("Commission.") String commission,
		@ApiModelProperty("Asset on which commission is taken.") String commissionAsset, @ApiModelProperty("Trade execution time.") long time,
		@ApiModelProperty("The symbol of the trade.") String symbol, @ApiModelProperty("The order id.") String orderId,
		@ApiModelProperty("The order list id.") String orderListId, @ApiModelProperty("Is buyer trade.") boolean isBuyer,
		@ApiModelProperty("Is maker trade.") boolean isMaker, @ApiModelProperty("Is best match?") boolean isBestMatch) {
}