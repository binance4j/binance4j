package com.binance4j.mining.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @param poolUsername   Transfer out of sub-account.
 * @param toPoolUsername Transfer into subaccount.
 * @param algoName       Transfer algorithm.
 * @param hashRate       Transferred Hashrate quantity.
 * @param day            Transfer date.
 * @param amount         Transferred income.
 * @param coinName       Coin Name.
 */
@ApiModel("")
public record HashrateResaleDetail(@ApiModelProperty("") String poolUsername, @ApiModelProperty("") String toPoolUsername,
		@ApiModelProperty("") String algoName, @ApiModelProperty("") long hashRate, @ApiModelProperty("") long day, @ApiModelProperty("") String amount,
		@ApiModelProperty("") String coinName) {
}
