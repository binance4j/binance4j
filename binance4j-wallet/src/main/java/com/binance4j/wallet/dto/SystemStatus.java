package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The system status.
 * 
 * @param status The system status code (0: normal，1：maintenance).
 * @param msg    The system status message ("normal" or "system_maintenance").
 */
@ApiModel("")
public record SystemStatus(@ApiModelProperty("") int status, @ApiModelProperty("") String msg) {
}