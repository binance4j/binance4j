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
@ApiModel("")
public record OCOOrderReport(@ApiModelProperty("") String symbol, @ApiModelProperty("") long orderId, @ApiModelProperty("") long orderListId,
		@ApiModelProperty("") String clientOrderId, @ApiModelProperty("") long transactTime, @ApiModelProperty("") String price,
		@ApiModelProperty("") String origQty, @ApiModelProperty("") String executedQty, @ApiModelProperty("") String cummulativeQuoteQty,
		@ApiModelProperty("") String status, @ApiModelProperty("") String timeInForce, @ApiModelProperty("") String type, @ApiModelProperty("") String side,
		@ApiModelProperty("") String stopPrice) {
}
