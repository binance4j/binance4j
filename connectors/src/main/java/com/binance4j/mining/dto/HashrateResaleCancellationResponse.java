package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hahsrate cancellation response.
 * 
 * @property code Code.
 * @property msg  Message.
 * @property data Cancellation success.
 */
@ApiModel("Hahsrate cancellation response.")
data class HashrateResaleCancellationResponse(
@ApiModelProperty("Code.")
 var code:Int = 0,
@ApiModelProperty("Message.")
 val msg : String,
@ApiModelProperty("Cancellation success.")  val data : Boolean)
{
}
