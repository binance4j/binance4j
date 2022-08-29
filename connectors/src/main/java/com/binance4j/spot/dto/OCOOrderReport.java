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
 val symbol : String,
@ApiModelProperty("Order Id.")
 val orderId : Long,
@ApiModelProperty("Order List Id.")
 val orderListId : Long,
@ApiModelProperty("Client Order Id.")
 val clientOrderId : String,
@ApiModelProperty("Transact Time.")
 val transactTime : Long,
@ApiModelProperty("Price.")
 val price : String,
@ApiModelProperty("Original Quantity.")
 val origQty : String,
@ApiModelProperty("Executed Quantity.")
 val executedQty : String,
@ApiModelProperty("Cummulative Quote Quantity.")
 val cummulativeQuoteQty : String,
@ApiModelProperty("Status.")
 val status : String,
@ApiModelProperty("Time In Force.")
 val timeInForce : String,
@ApiModelProperty("Type.")
 val type : String,
@ApiModelProperty("Side.")
 val side : String,
@ApiModelProperty("StopPrice.")
 val stopPrice : String)
{
}
