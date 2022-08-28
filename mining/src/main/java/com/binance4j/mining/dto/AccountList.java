package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account statistics.
 * 
 * @param time     Time in ms.
 * @param hashrate Hashrate.
 * @param reject   Reject rate.
 */
@ApiModel("Account statistics.")
public record AccountList(@ApiModelProperty("Time in ms.") long time, @ApiModelProperty("Hashrate.") String hashrate,
		@ApiModelProperty("Reject rate.") String reject) {
}
