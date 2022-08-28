package com.binance4j.mining.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Miner details.
 * 
 * @property workerName    Mining Account name.
 * @property type          Type of hourly hashrate.
 * @property hashrateDatas Hashrate datas
 */
@ApiModel("Miner details.")
data class MinerDetails(
@ApiModelProperty("Mining Account name.")
var workerName:String?=null,
@ApiModelProperty("Type of hourly hashrate.")
var type:String?=null,
@ApiModelProperty("Hashrate datas") List<HashrateData> hashrateDatas)
{
}