package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The account snapshot data.
 * 
 * @param assets   The assets balances.
 * @param position Account snapshot position
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record FuturesSnapshotData(
		/** The assets balances. */
		List<FuturesSnapshotDataAssets> assets,
		/** Account snapshot position */
		List<FuturesAccountSnapshotPosition> position) {
}