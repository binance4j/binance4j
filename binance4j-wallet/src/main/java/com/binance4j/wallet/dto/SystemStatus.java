package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The system status.
 * 
 * @param status System status code (0: normal，1：maintenance).
 * @param msg    System status message ("normal" or "system_maintenance").
 */
@ApiModel("The system status.")
public record SystemStatus(@ApiModelProperty("System status code (0: normal，1：maintenance).") int status,
		@ApiModelProperty("System status message (\"normal\" or \"system_maintenance\").") String msg) {
}