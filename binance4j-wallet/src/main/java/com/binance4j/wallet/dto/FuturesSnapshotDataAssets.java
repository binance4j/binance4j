package com.binance4j.wallet.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The snapshot assets balances.
 * 
 * @param asset         Asset abbreviation.
 * @param marginBalance Margin balance.
 * @param walletBalance Wallet balance.
 */
@ApiModel("The snapshot assets balances.")
public record FuturesSnapshotDataAssets(@ApiModelProperty("Asset abbreviation.") String asset, @ApiModelProperty("Margin balance.") String marginBalance,
		@ApiModelProperty("Wallet balance.") String walletBalance) {
}