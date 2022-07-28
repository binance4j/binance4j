package com.binance4j.wallet.dto;

/** A daily SPOT account snapshot */
public record SpotAccountSnapshot(
		/** The snapshot type ("spot/margin/futures") */
		String type,
		/** The snapshot update timestamp. */
		long updateTime,
		/** The account snapshot data. */
		SpotAccountSnapshotData data) implements Snapshot {
}