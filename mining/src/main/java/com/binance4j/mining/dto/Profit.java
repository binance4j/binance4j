package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profit.
 * 
 * @property time           Mining date in ms.
 * @property hashTransfer   Transferred Hashrate.
 * @property transferAmount Transferred Income.
 * @property dayHashRate    Daily Hashrate.
 * @property profitAmount   Earnings Amount.
 * @property coinName       Coin type.
 * @property type           Type. 0: Mining Wallet 5: Mining Address 7: Pool
 *                       Savings 8: Transferred 31: Income Transfer 32:
 *                       Hashrate Resale-Mining Wallet 33: Hashrate Resale-Pool
 *                       Savings
 * @property status         Status. 0: Unpaid 1: Paying 2: Paid
 */
@ApiModel("Account profit.")
data class Profit(
@ApiModelProperty("Mining date in ms.")
@JsonProperty("time") var time:Long?=null,
@ApiModelProperty("Transferred Hashrate.")
@JsonProperty("type") var type:int?=null,
@ApiModelProperty("Transferred Income.")
@JsonProperty("hashTransfer") var hashTransfer:Long?=null,
@ApiModelProperty("Daily Hashrate.")
@JsonProperty("transferAmount") var transferAmount:String?=null,
@ApiModelProperty("Earnings Amount.")
@JsonProperty("dayHashRate") var dayHashRate:Long?=null,
@ApiModelProperty("Coin type.")
@JsonProperty("profitAmount") var profitAmount:String?=null,
@ApiModelProperty("Type. 0: Mining Wallet 5: Mining Address 7: Pool Savings 8: Transferred 31: Income Transfer 32: Hashrate Resale-Mining Wallet 33: Hashrate Resale-Pool Savings") String coinName,
@ApiModelProperty("Status. 0: Unpaid 1: Paying 2: Paid")
int status)
{
}