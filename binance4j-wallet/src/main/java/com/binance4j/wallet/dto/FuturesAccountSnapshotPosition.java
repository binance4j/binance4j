package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Futures account snapshot position.
 * 
 * @param symbol           Symbol.
 * @param entryPrice       Entry price.
 * @param markPrice        Mark price.
 * @param positionAmt      Position amount.
 * @param unRealizedProfit Unrealized profit.
 */
@ApiModel("Futures account snapshot position.")
public record FuturesAccountSnapshotPosition(@ApiModelProperty("Symbol.") String symbol, @ApiModelProperty("Entry price.") String entryPrice,
		@ApiModelProperty("Mark price.") String markPrice, @ApiModelProperty("Position amount.") String positionAmt,
		@ApiModelProperty("Unrealized profit.") String unRealizedProfit) {
}