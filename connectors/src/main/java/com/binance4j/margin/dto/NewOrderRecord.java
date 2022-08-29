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
@JsonProperty("orderId") var orderId: Long = 0L,
@ApiModelProperty("Traded symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Order side.")
@JsonProperty("side") var side:OrderSide?=null,
@ApiModelProperty("Order status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Order type.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Order time in force.")
@JsonProperty("timeInForce") var timeInForce: String = "",
@ApiModelProperty("Transaction time.")
@JsonProperty("transactTime") var transactTime: Long = 0L,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId: String = "",
@ApiModelProperty("Symbol price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Order original quantity.")
@JsonProperty("origQty") var origQty: String = "",
@ApiModelProperty("Order executed quantity.")
@JsonProperty("executedQty") var executedQty: String = "",
@ApiModelProperty("Cumulative quote quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty: String = "",
@ApiModelProperty("Margin buy borrow amount. Will not return if no margin trade happens.") String marginBuyBorrowAmount,
@ApiModelProperty("Margin buy borrow asset. Will not return if no margin trade happens.")
String marginBuyBorrowAsset,
@ApiModelProperty("Is the order isolated?")
@JsonProperty("isIsolated") var isIsolated: Boolean = false,
@ApiModelProperty("Filled trades.")
List<Trade> fills)
{
}