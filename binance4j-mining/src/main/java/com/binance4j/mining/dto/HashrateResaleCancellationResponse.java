package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param code Code.
 * @param msg  Message.
 * @param data Cancellation success.
 */
@ApiModel("")
public record HashrateResaleCancellationResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") boolean data) {
}
