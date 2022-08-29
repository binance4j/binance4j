package com.binance4j.margin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A loan interest rate.
 * 
 * @property asset             Related coin.
 * @property dailyInterestRate Daily interest rate.
 * @property timestamp         Timestamp of the applied interest rate in ms.
 * @property vipLevel          Account VIP level.
 */
@ApiModel("A loan interest rate.")
data class InterestRate(
@ApiModelProperty("Related coin.")
@JsonProperty("asset") var asset: String = "",
@ApiModelProperty("Daily interest rate.")
@JsonProperty("dailyInterestRate") var dailyInterestRate: String = "",
@ApiModelProperty("Timestamp of the applied interest rate in ms.")
@JsonProperty("timestamp") var timestamp: Long = 0L,
@ApiModelProperty("Account VIP level.") @JsonProperty("vipLevel") var vipLevel:Int = 0)
{
}