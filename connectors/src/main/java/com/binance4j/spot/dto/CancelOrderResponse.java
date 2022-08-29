package com.binance4j.spot.dto;

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
 */
@ApiModel("The CancelOrder request result.")
data class CancelOrderResponse(
@ApiModelProperty("Status.")
 val status : String,
@ApiModelProperty("Side.")
 val side : String,
@ApiModelProperty("Type.")
 val type : String,
@ApiModelProperty("Time in force.")
 val timeInForce : String,
@ApiModelProperty("Order id.")
 val orderId : Long,
@ApiModelProperty("Order list id.")
 val orderListId : Long,
@ApiModelProperty("Symbol.")
 val symbol : String,
@ApiModelProperty("Orig client order id.")
 val origClientOrderId : String,
@ApiModelProperty("Client order id.")
 val clientOrderId : String,
@ApiModelProperty("Executed quantity.")
 val executedQty : String,
@ApiModelProperty("Price.")
 val price : String,
@ApiModelProperty("Original quantity.")
 val origQty : String,
@ApiModelProperty("Cummulative quote quantity.")
 val cummulativeQuoteQty : String)
{
}