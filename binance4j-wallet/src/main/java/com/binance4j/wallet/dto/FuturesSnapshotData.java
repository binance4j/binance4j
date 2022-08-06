package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The account snapshot data.
 * 
 * @param assets   Assets balances.
 * @param position Account snapshot position.
 */
@ApiModel("The account snapshot data.")
public record FuturesSnapshotData(@ApiModelProperty("Assets balances.") List<FuturesSnapshotDataAssets> assets,
		@ApiModelProperty("Account snapshot position.") List<FuturesAccountSnapshotPosition> position) {
}