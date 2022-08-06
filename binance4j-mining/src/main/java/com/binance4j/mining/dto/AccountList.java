package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account statistics
 * 
 * @param time     Time in ms.
 * @param hashrate Hashrate.
 * @param reject   Reject rate.
 */
@ApiModel("")
public record AccountList(@ApiModelProperty("") long time, @ApiModelProperty("") String hashrate, @ApiModelProperty("") String reject) {
}
