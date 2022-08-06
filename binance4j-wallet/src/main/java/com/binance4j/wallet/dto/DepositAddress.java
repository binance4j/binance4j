package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A deposit address for a given asset.
 * 
 * @param url     The deposit url.
 * @param address The deposit address.
 * @param tag     The deposit tag.
 * @param coin    The coin abbreviation.
 */
@ApiModel("")
public record DepositAddress(@ApiModelProperty("") String url, @ApiModelProperty("") String address, @ApiModelProperty("") String tag,
		@ApiModelProperty("") String coin) {
}