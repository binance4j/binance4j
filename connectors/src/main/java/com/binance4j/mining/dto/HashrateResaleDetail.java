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
val toPoolUsername : String,
@ApiModelProperty("Transfer algorithm.")
@JsonProperty("algoName ")
val algoName : String,
@ApiModelProperty("Transferred Hashrate quantity.") @JsonProperty("hashRate : Long = 0L, @ApiModelProperty("Transfer date.") var day ")
val hashRate : Long,
@ApiModelProperty("Transfer date.")
val day : Long,
@ApiModelProperty("Transferred income.") @JsonProperty("amount : String = "", @ApiModelProperty("Coin Name.") var coinName ")
val amount : String,
@ApiModelProperty("Coin Name.")
val coinName : String)
{
}
