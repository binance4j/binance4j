package com.binance4j.wallet.dto;

/** A daily MARGIN account snapshot */
public record MarginAccountSnapshot(
		/** The snapshot type ("spot/margin/futures") */
		String type,
		/** The snapshot update timestamp. */
		long updateTime,
		/** The account snapshot data. */
		MarginAccountSnapshotData data) implements Snapshot {
}