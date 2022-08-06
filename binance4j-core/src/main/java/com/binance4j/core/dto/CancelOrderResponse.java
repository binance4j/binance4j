package com.binance4j.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The CancelOrder request result.
 * 
 * @param status              Status.
 * @param side                Side.
 * @param type                Type.
 * @param timeInForce         Time in force.
 * @param orderId             Order id.
 * @param orderListId         Order list id.
 * @param symbol              Symbol.
 * @param origClientOrderId   Orig client order id.
 * @param clientOrderId       Client order id.
 * @param executedQty         Executed quantity.
 * @param price               Price.
 * @param origQty             Original quantity.
 * @param cummulativeQuoteQty Cummulative quote quantity.
 * @param isIsolated          Is isolated.
 */
@ApiModel("The CancelOrder request result.")
public record CancelOrderResponse(@ApiModelProperty("Status.") String status, @ApiModelProperty("Side.") String side, @ApiModelProperty("Type.") String type,
		@ApiModelProperty("Time in force.") String timeInForce, @ApiModelProperty("Order id.") long orderId,
		@ApiModelProperty("Order list id.") long orderListId, @ApiModelProperty("Symbol.") String symbol,
		@ApiModelProperty("Orig client order id.") String origClientOrderId, @ApiModelProperty("Client order id.") String clientOrderId,
		@ApiModelProperty("Executed quantity.") String executedQty, @ApiModelProperty("Price.") String price,
		@ApiModelProperty("Original quantity.") String origQty, @ApiModelProperty("Cummulative quote quantity.") String cummulativeQuoteQty,
		@ApiModelProperty("Is isolated.") boolean isIsolated) {
}