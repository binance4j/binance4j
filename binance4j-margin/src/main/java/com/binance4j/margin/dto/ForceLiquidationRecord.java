package com.binance4j.margin.dto;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Market order to exit leveraged position.
 * 
 * @param orderId     Order id.
 * @param updatedTime Liquidation timestamp in ms.
 * @param avgPrice    Symbol average price.
 * @param executedQty Executed quantity.
 * @param timeInForce Order time in force.
 * @param side        Order side.
 * @param symbol      Order symbol.
 * @param price       Order price.
 * @param qty         Order total quantity.
 * @param isIsolated  Is is isolated?
 */
@ApiModel("Market order to exit leveraged position.")
public record ForceLiquidationRecord(@ApiModelProperty("Order id.") long orderId, @ApiModelProperty("Liquidation timestamp in ms.") long updatedTime,
		@ApiModelProperty("Symbol average price.") String avgPrice, @ApiModelProperty("Executed quantity.") String executedQty,
		@ApiModelProperty("Order time in force.") TimeInForce timeInForce, @ApiModelProperty("Order side.") OrderSide side,
		@ApiModelProperty("Order symbol.") String symbol, @ApiModelProperty("Order price.") String price, @ApiModelProperty("Order total quantity.") String qty,
		@ApiModelProperty("Is is isolated?") boolean isIsolated) {
}