package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A miner/worker data.
 * 
 * @property workerId      Miner id.
 * @property workerName    Miner's name'.
 * @property status        Status：1 valid,2 invalid, 3 no longer valid.
 * @property hashRate      Real-time rate.
 * @property dayHashRate   24H Hashrate.
 * @property rejectRate    Real-time Rejection Rate.
 * @property lastShareTime Last submission time.
 */
@ApiModel("A miner/worker data.")
data class Worker(
@ApiModelProperty("Miner id.")
 val workerId : String,
@ApiModelProperty("Miner's name'.") String workerName,
@ApiModelProperty("Status：1 valid,2 invalid, 3 no longer valid.")
long status,
@ApiModelProperty("Real-time rate.")
long hashRate,
@ApiModelProperty("24H Hashrate.")
long dayHashRate,
@ApiModelProperty("Real-time Rejection Rate.")
long rejectRate,
@ApiModelProperty("Last submission time.")
 val lastShareTime : Long)
{
}