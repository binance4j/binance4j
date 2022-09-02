package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Trade order information.
 * 
 * @property side                Order side.
 * @property price               Price.
 * @property origQty             Original quantity.
 * @property executedQty         Original quantity.
 * @property cummulativeQuoteQty Used to calculate the average price.
 * @property status              Order status.
 * @property timeInForce         Time in force to indicate how long will the order
 *                            remain active.
 * @property type                Type of order.
 * @property stopPrice           Used with stop orders.
 * @property icebergQty          Used with iceberg orders.
 * @property time                Order timestamp.
 * @property updateTime          Update timestamp.
 * @property origQuoteOrderQty   Original quote order quantity.
 * @property isWorking           is working.
 * @property isIsolated          is isolated margin.
 * @property symbol              Order symbol.
 * @property orderId             Order id.
 * @property clientOrderId       Client order id.
 * @property accountId           Account id.
 */
@ApiModel("Trade order information.")
data class OrderInfo(
@ApiModelProperty("The order side.")
 val side : String,
@ApiModelProperty("Price.")
 val price : String,
@ApiModelProperty("Original quantity.")
 val origQty : String,
@ApiModelProperty("Original quantity.")
 val executedQty : String,
@ApiModelProperty("Used to calculate the average price.")
 val cummulativeQuoteQty : String,
@ApiModelProperty("Order status.")
 val status : String,
@ApiModelProperty("Time in force to indicate how long will the order remain active.")
 val timeInForce : String,
@ApiModelProperty("Type of order.")
 val type : String,
@ApiModelProperty("Used with stop orders.")
 val stopPrice : String,
@ApiModelProperty("Used with iceberg orders.")
 val icebergQty : String,
@ApiModelProperty("Order timestamp.")
 val time : Long,
@ApiModelProperty("Update timestamp.")
 val updateTime : Long,
@ApiModelProperty("Original quote order quantity.")
 val origQuoteOrderQty : String,
@ApiModelProperty("is working.")
 val isWorking : Boolean,
@ApiModelProperty("is isolated margin.")
 val isIsolated : Boolean,
@ApiModelProperty("The order symbol.")
 val symbol : String,
@ApiModelProperty("Order id.")
 val orderId : Long,
@ApiModelProperty("Client order id.")
 val clientOrderId : String,
@ApiModelProperty("Account id.")
 val accountId : String)
{
}