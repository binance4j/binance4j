package com.binance4j.spot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * OCO order report.
 * 
 * @property symbol              Symbol.
 * @property orderId             Order Id.
 * @property orderListId         Order List Id.
 * @property clientOrderId       Client Order Id.
 * @property transactTime        Transact Time.
 * @property price               Price.
 * @property origQty             Original Quantity.
 * @property executedQty         Executed Quantity.
 * @property cummulativeQuoteQty Cummulative Quote Quantity.
 * @property status              Status.
 * @property timeInForce         Time In Force.
 * @property type                Type.
 * @property side                Side.
 * @property stopPrice           StopPrice.
 */
@ApiModel("OCO order report.")
data class OCOOrderReport(
@ApiModelProperty("Symbol.")
@JsonProperty("symbol") var symbol: String = "",
@ApiModelProperty("Order Id.")
@JsonProperty("orderId") var orderId: Long = 0L,
@ApiModelProperty("Order List Id.")
@JsonProperty("orderListId") var orderListId: Long = 0L,
@ApiModelProperty("Client Order Id.")
@JsonProperty("clientOrderId") var clientOrderId: String = "",
@ApiModelProperty("Transact Time.")
@JsonProperty("transactTime") var transactTime: Long = 0L,
@ApiModelProperty("Price.")
@JsonProperty("price") var price: String = "",
@ApiModelProperty("Original Quantity.")
@JsonProperty("origQty") var origQty: String = "",
@ApiModelProperty("Executed Quantity.")
@JsonProperty("executedQty") var executedQty: String = "",
@ApiModelProperty("Cummulative Quote Quantity.")
@JsonProperty("cummulativeQuoteQty") var cummulativeQuoteQty: String = "",
@ApiModelProperty("Status.")
@JsonProperty("status") var status: String = "",
@ApiModelProperty("Time In Force.")
@JsonProperty("timeInForce") var timeInForce: String = "",
@ApiModelProperty("Type.")
@JsonProperty("type") var type: String = "",
@ApiModelProperty("Side.")
@JsonProperty("side") var side: String = "",
@ApiModelProperty("StopPrice.")
@JsonProperty("stopPrice") var stopPrice: String = "")
{
}
