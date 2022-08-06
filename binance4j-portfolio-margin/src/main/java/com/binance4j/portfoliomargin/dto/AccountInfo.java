package com.binance4j.portfoliomargin.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Margin portfolio account infos.
 * 
 * @param uniMMR             Portfolio margin account maintenance margin rate
 * @param accountEquity      Account equity, unit：USD
 * @param accountMaintMargin Portfolio margin account maintenance margin, unit：USD
 * @param accountStatus      Portfolio margin account. status: NORMAL, "MARGIN_CALL", "SUPPLY_MARGIN", "REDUCE_ONLY",
 *                               "ACTIVE_LIQUIDATION", "FORCE_LIQUIDATION", "BANKRUPTED"
 */
@ApiModel("Margin portfolio account infos.")
public record AccountInfo(@ApiModelProperty("Portfolio margin account maintenance margin rate") String uniMMR,
		@ApiModelProperty("Account equity, unit：USD") String accountEquity,
		@ApiModelProperty("Portfolio margin account maintenance margin, unit：USD") String accountMaintMargin,
		@ApiModelProperty("Portfolio margin account. status: NORMAL, MARGIN_CALL, SUPPLY_MARGIN, REDUCE_ONLY, ACTIVE_LIQUIDATION, FORCE_LIQUIDATION, BANKRUPTED") String accountStatus) {
}
