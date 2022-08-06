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
@ApiModel("")
public record MinerDetails(@ApiModelProperty("") String workerName, @ApiModelProperty("") String type, @ApiModelProperty("") List<HashrateData> hashrateDatas) {
}