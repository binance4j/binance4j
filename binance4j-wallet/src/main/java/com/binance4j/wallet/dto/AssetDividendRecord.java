package com.binance4j.wallet.dto;

import java.util.List;

/**
 * An asset divident record.
 * 
 * @param rows  The records.
 * @param total The number of record.
 */
public record AssetDividendRecord(
		/** The records. */
		List<AssetDividend> rows,
		/** The number of record. */
		long total) {
}
