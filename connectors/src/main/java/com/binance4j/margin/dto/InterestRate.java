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
 val asset : String,
@ApiModelProperty("Daily interest rate.")
 val dailyInterestRate : String,
@ApiModelProperty("Timestamp of the applied interest rate in ms.")
 val timestamp : Long,
@ApiModelProperty("Account VIP level.")  var vipLevel:Int = 0)
{
}