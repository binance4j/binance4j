package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.Trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An newly placed order record.
 * 
 * @param orderId               Order id.
 * @param symbol                Traded symbol.
 * @param side                  Order side.
 * @param status                Order status.
 * @param type                  Order type.
 * @param timeInForce           Order time in force.
 * @param transactTime          Transaction time.
 * @param clientOrderId         Client order id.
 * @param price                 Symbol price.
 * @param origQty               Order original quantity.
 * @param executedQty           Order executed quantity.
 * @param cummulativeQuoteQty   Cumulative quote quantity.
 * @param marginBuyBorrowAmount Margin buy borrow amount. Will not return if no margin trade happens.
 * @param marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no margin trade happens.
 * @param isIsolated            Is the order isolated?
 * @param fills                 Filled trades.
 */
@ApiModel("An newly placed order record.")
public record NewOrderRecord(@ApiModelProperty("Order id.") long orderId, @ApiModelProperty("Traded symbol.") String symbol,
		@ApiModelProperty("Order side.") OrderSide side, @ApiModelProperty("Order status.") String status, @ApiModelProperty("Order type.") String type,
		@ApiModelProperty("Order time in force.") String timeInForce, @ApiModelProperty("Transaction time.") long transactTime,
		@ApiModelProperty("Client order id.") String clientOrderId, @ApiModelProperty("Symbol price.") String price,
		@ApiModelProperty("Order original quantity.") String origQty, @ApiModelProperty("Order executed quantity.") String executedQty,
		@ApiModelProperty("Cumulative quote quantity.") String cummulativeQuoteQty,
		@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") String marginBuyBorrowAmount,
		@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.") String marginBuyBorrowAsset,
		@ApiModelProperty("Is the order isolated?") boolean isIsolated, @ApiModelProperty("Filled trades.") List<Trade> fills) {
}