package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A deposit address for a given asset.
 * 
 * @param url     Deposit url.
 * @param address Deposit address.
 * @param tag     Deposit tag.
 * @param coin    Coin abbreviation.
 */
@ApiModel("A deposit address for a given asset.")
public record DepositAddress(@ApiModelProperty("Deposit url.") String url, @ApiModelProperty("Deposit address.") String address,
		@ApiModelProperty("Deposit tag.") String tag, @ApiModelProperty("Coin abbreviation.") String coin) {
}