package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param code Code.
 * @param msg  Message.
 * @param data Mining account.
 */
@ApiModel("")
public record HashrateResaleResponse(@ApiModelProperty("") int code, @ApiModelProperty("") String msg, @ApiModelProperty("") int data) {
}
