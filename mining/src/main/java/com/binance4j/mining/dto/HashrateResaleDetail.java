package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Hashrate resale detail.
 * 
 * @param poolUsername   Transfer out of sub-account.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param day            Transfer date.
 * @param amount         Transferred income.
 * @param coinName       Coin Name.
 */
@ApiModel("Hashrate resale detail.")
public record HashrateResaleDetail(@ApiModelProperty("Transfer out of sub-account.") String poolUsername,
		@ApiModelProperty("Transfer into subaccount.") String toPoolUsername,
		@ApiModelProperty("Transfer algorithm.") String algoName,
		@ApiModelProperty("Transferred Hashrate quantity.") long hashRate, @ApiModelProperty("Transfer date.") long day,
		@ApiModelProperty("Transferred income.") String amount, @ApiModelProperty("Coin Name.") String coinName) {
}
