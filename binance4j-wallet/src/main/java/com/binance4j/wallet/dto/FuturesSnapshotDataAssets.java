package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The snapshot assets balances.
 * 
 * @param asset         The asset abbreviation.
 * @param marginBalance The margin balance.
 * @param walletBalance The wallet balance.
 */
@ApiModel("")
public record FuturesSnapshotDataAssets(@ApiModelProperty("") String asset, @ApiModelProperty("") String marginBalance,
		@ApiModelProperty("") String walletBalance) {
}