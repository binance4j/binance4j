package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** Futures account snapshot position. */
@ApiModel("")
public record FuturesAccountSnapshotPosition(@ApiModelProperty("") String symbol, @ApiModelProperty("") String entryPrice,
		@ApiModelProperty("") String markPrice, @ApiModelProperty("") String positionAmt, @ApiModelProperty("") String unRealizedProfit) {
}