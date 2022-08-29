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
 var configId:Int = 0,
@ApiModelProperty("Transfer out of subaccount.")
 val poolUsername : String,
@ApiModelProperty("Transfer into subaccount.")
 val toPoolUsername : String,
@ApiModelProperty("Transfer algorithm.")
 val algoName : String,
@ApiModelProperty("Transferred Hashrate quantity.")
 val hashRate : Long,
@ApiModelProperty("Start date.")
 val startDay : Long,
@ApiModelProperty("End date.")
 val endDay : Long,
@ApiModelProperty("Status：0 Processing，1：Cancelled，2：Terminated.") int status)
{
}
