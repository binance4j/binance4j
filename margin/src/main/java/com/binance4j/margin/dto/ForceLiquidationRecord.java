package com.binance4j.margin.dto;

import com.binance4j.core.dto.OrderSide;
import com.binance4j.core.dto.TimeInForce;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Market order to exit leveraged position.
 * 
 * @property orderId     Order id.
 * @property updatedTime Liquidation timestamp in ms.
 * @property avgPrice    Symbol average price.
 * @property executedQty Executed quantity.
 * @property timeInForce Order time in force.
 * @property side        Order side.
 * @property symbol      Order symbol.
 * @property price       Order price.
 * @property qty         Order total quantity.
 * @property isIsolated  Is is isolated?
 */
@ApiModel("Market order to exit leveraged position.")
data class ForceLiquidationRecord(
@ApiModelProperty("Order id.")
var orderId:Long?=null,
@ApiModelProperty("Liquidation timestamp in ms.")
var updatedTime:Long?=null,
@ApiModelProperty("Symbol average price.")
var avgPrice:String?=null,
@ApiModelProperty("Executed quantity.")
var executedQty:String?=null,
@ApiModelProperty("Order time in force.")
var timeInForce:TimeInForce?=null,
@ApiModelProperty("Order side.")
var side:OrderSide?=null,
@ApiModelProperty("Order symbol.")
var symbol:String?=null,
@ApiModelProperty("Order price.")
var price:String?=null,
@ApiModelProperty("Order total quantity.")
var qty:String?=null,
@ApiModelProperty("Is is isolated?") var isIsolated:Boolean?=null)
{
}