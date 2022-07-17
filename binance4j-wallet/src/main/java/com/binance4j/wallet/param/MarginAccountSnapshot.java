package com.binance4j.wallet.param;

import com.binance4j.wallet.dto.Snapshot;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A daily MARGIN account snapshot */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginAccountSnapshot(
		/** The snapshot type ("spot/margin/futures") */
		String type,
		/** The snapshot update timestamp. */
		long updateTime,
		/** The account snapshot data. */
		MarginAccountSnapshotData data) implements Snapshot {
}