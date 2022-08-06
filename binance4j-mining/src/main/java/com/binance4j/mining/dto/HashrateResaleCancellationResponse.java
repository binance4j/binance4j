package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hahsrate cancellation response.
 * 
 * @param code Code.
 * @param msg  Message.
 * @param data Cancellation success.
 */
@ApiModel("Hahsrate cancellation response.")
public record HashrateResaleCancellationResponse(@ApiModelProperty("Code.") int code, @ApiModelProperty("Message.") String msg,
		@ApiModelProperty("Cancellation success.") boolean data) {
}
