package com.binance4j.wallet.dto;

import java.util.List;

/**
 * The account snapshot data.
 * 
 * @param assets   The assets balances.
 * @param position Account snapshot position
 */
public record FuturesSnapshotData(List<FuturesSnapshotDataAssets> assets, List<FuturesAccountSnapshotPosition> position) {
}