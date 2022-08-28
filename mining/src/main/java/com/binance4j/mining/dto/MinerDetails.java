package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Miner details.
 * 
 * @param workerName    Mining Account name.
 * @param type          Type of hourly hashrate.
 * @param hashrateDatas Hashrate datas
 */
@ApiModel("Miner details.")
public record MinerDetails(@ApiModelProperty("Mining Account name.") String workerName,
		@ApiModelProperty("Type of hourly hashrate.") String type,
		@ApiModelProperty("Hashrate datas") List<HashrateData> hashrateDatas) {
}