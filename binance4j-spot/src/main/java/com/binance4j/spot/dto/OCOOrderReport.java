package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO order report.
 * 
 * @param symbol              Symbol.
 * @param orderId             Order Id.
 * @param orderListId         Order List Id.
 * @param clientOrderId       Client Order Id.
 * @param transactTime        Transact Time.
 * @param price               Price.
 * @param origQty             Original Quantity.
 * @param executedQty         Executed Quantity.
 * @param cummulativeQuoteQty Cummulative Quote Quantity.
 * @param status              Status.
 * @param timeInForce         Time In Force.
 * @param type                Type.
 * @param side                Side.
 * @param stopPrice           StopPrice.
 */
@ApiModel("OCO order report.")
public record OCOOrderReport(@ApiModelProperty("Symbol.") String symbol, @ApiModelProperty("Order Id.") long orderId,
		@ApiModelProperty("Order List Id.") long orderListId, @ApiModelProperty("Client Order Id.") String clientOrderId,
		@ApiModelProperty("Transact Time.") long transactTime, @ApiModelProperty("Price.") String price, @ApiModelProperty("Original Quantity.") String origQty,
		@ApiModelProperty("Executed Quantity.") String executedQty, @ApiModelProperty("Cummulative Quote Quantity.") String cummulativeQuoteQty,
		@ApiModelProperty("Status.") String status, @ApiModelProperty("Time In Force.") String timeInForce, @ApiModelProperty("Type.") String type,
		@ApiModelProperty("Side.") String side, @ApiModelProperty("StopPrice.") String stopPrice) {
}
