package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate data.
 * 
 * @param time     Time in ms.
 * @param hashrate Hashrate.
 * @param reject   Rejection Rate.
 */
@ApiModel("")
public record HashrateData(@ApiModelProperty("") long time, @ApiModelProperty("") String hashrate, @ApiModelProperty("") long reject) {
}