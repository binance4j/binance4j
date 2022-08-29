package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate resale detail.
 * 
 * @property poolUsername   Transfer out of sub-account.
 * @property toPoolUsername Transfer into subaccount.
 * @property algoName       Transfer algorithm.
 * @property hashRate       Transferred Hashrate quantity.
 * @property day            Transfer date.
 * @property amount         Transferred income.
 * @property coinName       Coin Name.
 */
@ApiModel("Hashrate resale detail.")
data class HashrateResaleDetail(
@ApiModelProperty("Transfer out of sub-account.")
String poolUsername,
@ApiModelProperty("Transfer into subaccount.")
@JsonProperty("toPoolUsername ")
var toPoolUsername: String = "",
@ApiModelProperty("Transfer algorithm.")
@JsonProperty("algoName ")
var algoName: String = "",
@ApiModelProperty("Transferred Hashrate quantity.") @JsonProperty("hashRate : Long = 0L, @ApiModelProperty("Transfer date.") var day ")
var hashRate: Long = 0L,
@ApiModelProperty("Transfer date.")
var day: Long = 0L,
@ApiModelProperty("Transferred income.") @JsonProperty("amount : String = "", @ApiModelProperty("Coin Name.") var coinName ")
var amount: String = "",
@ApiModelProperty("Coin Name.")
var coinName: String = "")
{
}
