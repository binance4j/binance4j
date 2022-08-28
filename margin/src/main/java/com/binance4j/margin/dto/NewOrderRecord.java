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
var orderId:Long?=null,
@ApiModelProperty("Traded symbol.")
var symbol:String?=null,
@ApiModelProperty("Order side.")
var side:OrderSide?=null,
@ApiModelProperty("Order status.")
var status:String?=null,
@ApiModelProperty("Order type.")
var type:String?=null,
@ApiModelProperty("Order time in force.")
var timeInForce:String?=null,
@ApiModelProperty("Transaction time.")
var transactTime:Long?=null,
@ApiModelProperty("Client order id.")
var clientOrderId:String?=null,
@ApiModelProperty("Symbol price.")
var price:String?=null,
@ApiModelProperty("Order original quantity.")
var origQty:String?=null,
@ApiModelProperty("Order executed quantity.")
var executedQty:String?=null,
@ApiModelProperty("Cumulative quote quantity.")
var cummulativeQuoteQty:String?=null,
@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") String marginBuyBorrowAmount,
@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
String marginBuyBorrowAsset,
@ApiModelProperty("Is the order isolated?")
var isIsolated:Boolean?=null,
@ApiModelProperty("Filled trades.")
List<Trade> fills)
{
}