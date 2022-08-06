package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A miner/worker data.
 * 
 * @param workerId      The miner id.
 * @param workerName    The miner's name'.
 * @param status        Status：1 valid,@ApiModelProperty("") 2 invalid,@ApiModelProperty("") 3 no longer valid.
 * @param hashRate      Real-time rate.
 * @param dayHashRate   24H Hashrate.
 * @param rejectRate    Real-time Rejection Rate.
 * @param lastShareTime Last submission time.
 */
@ApiModel("")
public record Worker(@ApiModelProperty("") String workerId, @ApiModelProperty("") String workerName, @ApiModelProperty("") long status,
		@ApiModelProperty("") long hashRate, @ApiModelProperty("") long dayHashRate, @ApiModelProperty("") long rejectRate,
		@ApiModelProperty("") long lastShareTime) {
}