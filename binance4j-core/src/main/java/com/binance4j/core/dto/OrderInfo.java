package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trade order information.
 * 
 * @param side                The order side.
 * @param price               Price.
 * @param origQty             Original quantity.
 * @param executedQty         Original quantity.
 * @param cummulativeQuoteQty Used to calculate the average price.
 * @param status              Order status.
 * @param timeInForce         Time in force to indicate how long will the order remain active.
 * @param type                Type of order.
 * @param stopPrice           Used with stop orders.
 * @param icebergQty          Used with iceberg orders.
 * @param time                Order timestamp.
 * @param updateTime          Update timestamp.
 * @param origQuoteOrderQty   Original quote order quantity.
 * @param isWorking           is working.
 * @param isIsolated          is isolated margin.
 * @param symbol              The order symbol.
 * @param orderId             Order id.
 * @param clientOrderId       Client order id.
 * @param accountId           Account id.
 */
@ApiModel("Trade order information.")
public record OrderInfo(@ApiModelProperty("The order side.") String side, @ApiModelProperty("Price.") String price,
		@ApiModelProperty("Original quantity.") String origQty, @ApiModelProperty("Original quantity.") String executedQty,
		@ApiModelProperty("Used to calculate the average price.") String cummulativeQuoteQty, @ApiModelProperty("Order status.") String status,
		@ApiModelProperty("Time in force to indicate how long will the order remain active.") String timeInForce,
		@ApiModelProperty("Type of order.") String type, @ApiModelProperty("Used with stop orders.") String stopPrice,
		@ApiModelProperty("Used with iceberg orders.") String icebergQty, @ApiModelProperty("Order timestamp.") long time,
		@ApiModelProperty("Update timestamp.") long updateTime, @ApiModelProperty("Original quote order quantity.") String origQuoteOrderQty,
		@ApiModelProperty("is working.") boolean isWorking, @ApiModelProperty("is isolated margin.") boolean isIsolated,
		@ApiModelProperty("The order symbol.") String symbol, @ApiModelProperty("Order id.") long orderId,
		@ApiModelProperty("Client order id.") String clientOrderId, @ApiModelProperty("Account id.") String accountId) {
}