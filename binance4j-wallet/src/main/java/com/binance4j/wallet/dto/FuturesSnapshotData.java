package com.binance4j.wallet.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The account snapshot data.
 * 
 * @param assets   The assets balances.
 * @param position Account snapshot position
 */
@ApiModel("")
public record FuturesSnapshotData(@ApiModelProperty("") List<FuturesSnapshotDataAssets> assets,
		@ApiModelProperty("") List<FuturesAccountSnapshotPosition> position) {
}