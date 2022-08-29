package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The CancelOrder request result.
 * 
 * @property status              Status.
 * @property side                Side.
 * @property type                Type.
 * @property timeInForce         Time in force.
 * @property orderId             Order id.
 * @property orderListId         Order list id.
 * @property symbol              Symbol.
 * @property origClientOrderId   Orig client order id.
 * @property clientOrderId       Client order id.
 * @property executedQty         Executed quantity.
 * @property price               Price.
 * @property origQty             Original quantity.
 * @property cummulativeQuoteQty Cummulative quote quantity.
 * @property isIsolated          Is isolated.
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
@ApiModelProperty("Status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Side.")
@JsonProperty("side") var side: String = "",
@ApiModelProperty("Type.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Time in force.")
@JsonProperty("timeInForce") var timeInForce: String = "",
@ApiModelProperty("Order id.")
@JsonProperty("orderId") var orderId: Long = 0L,
@ApiModelProperty("Order list id.")
@JsonProperty("orderListId") var orderListId: Long = 0L,
@ApiModelProperty("Symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Orig client order id.")
@JsonProperty("origClientOrderId") var origClientOrderId: String = "",
@ApiModelProperty("Client order id.")
@JsonProperty("clientOrderId") var clientOrderId: String = "",
@ApiModelProperty("Executed quantity.")
@JsonProperty("executedQty") var executedQty: String = "",
@ApiModelProperty("Price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Original quantity.")
@JsonProperty("origQty") var origQty: String = "",
@ApiModelProperty("Cummulative quote quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty: String = "",
@ApiModelProperty("Is isolated.") @JsonProperty("isIsolated") var isIsolated: Boolean = false)
{
}