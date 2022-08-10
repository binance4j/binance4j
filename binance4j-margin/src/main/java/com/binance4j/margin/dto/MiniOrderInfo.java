package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trade order information.
 * 
 * @param symbol        Order symbol.
 * @param orderId       Order id.
 * @param clientOrderId Client order id.
 */
@ApiModel("Trade order information.")
public record MiniOrderInfo(@ApiModelProperty("Order symbol.") String symbol,
		@ApiModelProperty("Order id.") long orderId,
		@ApiModelProperty("Client order id.") String clientOrderId) {
}