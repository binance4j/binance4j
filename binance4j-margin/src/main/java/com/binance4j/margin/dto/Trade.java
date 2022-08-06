package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A trade being part of a {@link NewOrderRecord}.
 * 
 * @param id              Trade id.
 * @param orderId         Related order id.
 * @param symbol          Traded symbol.
 * @param commissionAsset Commission asset .
 * @param commission      Commission amount.
 * @param price           Trade price.
 * @param qty             Traded quantity.
 * @param time            Transaction time.
 * @param isBestMatch     Is it the best match?
 * @param isBuyer         Is it a buyer trade?
 * @param isMaker         Is it a maker trade?
 * @param isIsolated      Is it an isolated trade?
 */
@ApiModel("A trade being part of a NewOrderRecord.")
public record Trade(@ApiModelProperty("Trade id.") long id, @ApiModelProperty("Related order id.") long orderId,
		@ApiModelProperty("Traded symbol.") String symbol, @ApiModelProperty("Commission asset .") String commissionAsset,
		@ApiModelProperty("Commission amount.") String commission, @ApiModelProperty("Trade price.") String price,
		@ApiModelProperty("Traded quantity.") String qty, @ApiModelProperty("Transaction time.") long time,
		@ApiModelProperty("Is it the best match?") boolean isBestMatch, @ApiModelProperty("Is it a buyer trade?") boolean isBuyer,
		@ApiModelProperty("Is it a maker trade?") boolean isMaker, @ApiModelProperty("Is it an isolated trade?") boolean isIsolated) {
}