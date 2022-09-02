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
 val orderId : Long,
@ApiModelProperty("Liquidation timestamp in ms.")
 val updatedTime : Long,
@ApiModelProperty("Symbol average price.")
 val avgPrice : String,
@ApiModelProperty("Executed quantity.")
 val executedQty : String,
@ApiModelProperty("Order time in force.")
 var timeInForce:TimeInForce?=null,
@ApiModelProperty("Order side.")
 var side:OrderSide?=null,
@ApiModelProperty("Order symbol.")
 val symbol : String,
@ApiModelProperty("Order price.")
 val price : String,
@ApiModelProperty("Order total quantity.")
 val qty : String,
@ApiModelProperty("Is is isolated?")  val isIsolated : Boolean)
{
}