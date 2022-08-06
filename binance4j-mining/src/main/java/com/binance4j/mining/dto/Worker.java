package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A miner/worker data.
 * 
 * @param workerId      Miner id.
 * @param workerName    Miner's name'.
 * @param status        Status：1 valid,2 invalid, 3 no longer valid.
 * @param hashRate      Real-time rate.
 * @param dayHashRate   24H Hashrate.
 * @param rejectRate    Real-time Rejection Rate.
 * @param lastShareTime Last submission time.
 */
@ApiModel("A miner/worker data.")
public record Worker(@ApiModelProperty("Miner id.") String workerId, @ApiModelProperty("Miner's name'.") String workerName,
		@ApiModelProperty("Status：1 valid,2 invalid, 3 no longer valid.") long status, @ApiModelProperty("Real-time rate.") long hashRate,
		@ApiModelProperty("24H Hashrate.") long dayHashRate, @ApiModelProperty("Real-time Rejection Rate.") long rejectRate,
		@ApiModelProperty("Last submission time.") long lastShareTime) {
}