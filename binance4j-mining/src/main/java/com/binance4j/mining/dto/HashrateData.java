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
@ApiModel("Hashrate data.")
public record HashrateData(@ApiModelProperty("Time in ms.") long time, @ApiModelProperty("Hashrate.") String hashrate,
		@ApiModelProperty("Rejection Rate.") long reject) {
}