package com.binance4j.spot.dto;

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
 * @property symbol              Order symbol.
 * @property orderId             Order id.
 * @property clientOrderId       Client order id.
 * @property orderListId         Order list id.
 * @property accountId           Account id.
 */
@ApiModel("Trade order information.")
data class OrderInfo(
@ApiModelProperty("The order side.")
@JsonProperty("side") var side: String = "",
@ApiModelProperty("Price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Original quantity.")
@JsonProperty("origQty") var origQty: String = "",
@ApiModelProperty("Original quantity.")
@JsonProperty("executedQty") var executedQty: String = "",
@ApiModelProperty("Used to calculate the average price.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty: String = "",
@ApiModelProperty("Order status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Time in force to indicate how long will the order remain active.")
@JsonProperty("timeInForce") var timeInForce: String = "",
@ApiModelProperty("Type of order.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Used with stop orders.")
@JsonProperty("stopPrice") var stopPrice: String = "",
@ApiModelProperty("Used with iceberg orders.")
@JsonProperty("icebergQty") var icebergQty: String = "",
@ApiModelProperty("Order timestamp.")
@JsonProperty("time") var time: Long = 0L,
@ApiModelProperty("Update timestamp.")
@JsonProperty("updateTime") var updateTime: Long = 0L,
@ApiModelProperty("Original quote order quantity.")
@JsonProperty("origQuoteOrderQty") var origQuoteOrderQty: String = "",
@ApiModelProperty("is working.")
@JsonProperty("isWorking") var isWorking: Boolean = false,
@ApiModelProperty("The order symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId: Long = 0L,
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId: String = "",
@ApiModelProperty("Order list id.")
@JsonProperty("orderListId") var orderListId: String = "",
@ApiModelProperty("Account id.")
@JsonProperty("accountId") var accountId: String = "")
{
}