package com.binance4j.margin.dto;

import java.util.List;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.Trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * An newly placed order record.
 * 
 * @property orderId               Order id.
 * @property symbol                Traded symbol.
 * @property side                  Order side.
 * @property status                Order status.
 * @property type                  Order type.
 * @property timeInForce           Order time in force.
 * @property transactTime          Transaction time.
 * @property clientOrderId         Client order id.
 * @property price                 Symbol price.
 * @property origQty               Order original quantity.
 * @property executedQty           Order executed quantity.
 * @property cummulativeQuoteQty   Cumulative quote quantity.
 * @property marginBuyBorrowAmount Margin buy borrow amount. Will not return if no
 *                              margin trade happens.
 * @property marginBuyBorrowAsset  Margin buy borrow asset. Will not return if no
 *                              margin trade happens.
 * @property isIsolated            Is the order isolated?
 * @property fills                 Filled trades.
 */
@ApiModel("An newly placed order record.")
data class NewOrderRecord(
@ApiModelProperty("Order id.")
 val orderId : Long,
@ApiModelProperty("Traded symbol.")
 val symbol : String,
@ApiModelProperty("Order side.")
 var side:OrderSide?=null,
@ApiModelProperty("Order status.")
 val status : String,
@ApiModelProperty("Order type.")
 val type : String,
@ApiModelProperty("Order time in force.")
 val timeInForce : String,
@ApiModelProperty("Transaction time.")
 val transactTime : Long,
@ApiModelProperty("Client order id.")
 val clientOrderId : String,
@ApiModelProperty("Symbol price.")
 val price : String,
@ApiModelProperty("Order original quantity.")
 val origQty : String,
@ApiModelProperty("Order executed quantity.")
 val executedQty : String,
@ApiModelProperty("Cumulative quote quantity.")
 val cummulativeQuoteQty : String,
@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") String marginBuyBorrowAmount,
@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
String marginBuyBorrowAsset,
@ApiModelProperty("Is the order isolated?")
 val isIsolated : Boolean,
@ApiModelProperty("Filled trades.")
List<Trade> fills)
{
}