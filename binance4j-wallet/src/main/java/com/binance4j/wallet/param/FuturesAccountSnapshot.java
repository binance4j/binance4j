package com.binance4j.wallet.param;

import com.binance4j.wallet.dto.FuturesSnapshotData;
import com.binance4j.wallet.dto.Snapshot;

/** A daily FUTURES account snapshot */
public record FuturesAccountSnapshot(
		/** The snapshot type ("spot/margin/futures") */
		String type,
		/** The snapshot update timestamp. */
		long updateTime,
		/** The account snapshot data. */
		FuturesSnapshotData data) implements Snapshot {
}