package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate resale list detail.
 * 
 * @property configId       Mining ID.
 * @property poolUsername   Transfer out of subaccount.
 * @property toPoolUsername Transfer into subaccount.
 * @property algoName       Transfer algorithm.
 * @property hashRate       Transferred Hashrate quantity.
 * @property startDay       Start date.
 * @property endDay         End date.
 * @property status         Status：0 Processing，1：Cancelled，2：Terminated.
 */
@ApiModel("Hashrate resale list detail.")
data class HashrateResaleListDetail(
@ApiModelProperty("Mining ID.")
@JsonProperty("configId") var configId:Int = 0,
@ApiModelProperty("Transfer out of subaccount.")
@JsonProperty("poolUsername") var poolUsername: String = "",
@ApiModelProperty("Transfer into subaccount.")
@JsonProperty("toPoolUsername") var toPoolUsername: String = "",
@ApiModelProperty("Transfer algorithm.")
@JsonProperty("algoName") var algoName: String = "",
@ApiModelProperty("Transferred Hashrate quantity.")
@JsonProperty("hashRate") var hashRate: Long = 0L,
@ApiModelProperty("Start date.")
@JsonProperty("startDay") var startDay: Long = 0L,
@ApiModelProperty("End date.")
@JsonProperty("endDay") var endDay: Long = 0L,
@ApiModelProperty("Status：0 Processing，1：Cancelled，2：Terminated.") int status)
{
}
