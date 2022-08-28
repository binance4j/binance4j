package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account profit.
 * 
 * @property time     Time in ms.
 * @property coinName Coin.
 * @property type     0:Referral 1：Refund 2：Rebate.
 * @property puid     Sub-account id.
 * @property subName  Mining account.
 * @property amount   Amount.
 */
@ApiModel("Account profit.")
data class AccountProfit(
@ApiModelProperty("Time in ms.")
@JsonProperty("time") var time:Long?=null,
@ApiModelProperty("Coin.")
@JsonProperty("coinName") var coinName:String?=null,
@ApiModelProperty("0:Referral 1：Refund 2：Rebate.") int type,
@ApiModelProperty("Sub-account id.")
int puid,
@ApiModelProperty("Mining account.")
@JsonProperty("subName") var subName:String?=null,
@ApiModelProperty("Amount.")
@JsonProperty("amount") var amount:String?=null)
{
}
