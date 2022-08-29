package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin portfolio account infos.
 * 
 * @property uniMMR             Portfolio margin account maintenance margin rate
 * @property accountEquity      Account equity, unit：USD
 * @property accountMaintMargin Portfolio margin account maintenance margin,
 *                           unit：USD
 * @property accountStatus      Portfolio margin account. status: NORMAL,
 *                           "MARGIN_CALL", "SUPPLY_MARGIN", "REDUCE_ONLY",
 *                           "ACTIVE_LIQUIDATION", "FORCE_LIQUIDATION",
 *                           "BANKRUPTED"
 */
@ApiModel("Margin portfolio account infos.")
data class AccountInfo(
@ApiModelProperty("Portfolio margin account maintenance margin rate")
@JsonProperty("uniMMR") var uniMMR: String = "",
@ApiModelProperty("Account equity, unit：USD") String accountEquity,
@ApiModelProperty("Portfolio margin account maintenance margin, unit：USD")
String accountMaintMargin,
@ApiModelProperty("Portfolio margin account. status: NORMAL, MARGIN_CALL, SUPPLY_MARGIN, REDUCE_ONLY, ACTIVE_LIQUIDATION, FORCE_LIQUIDATION, BANKRUPTED")
String accountStatus)
{
}
