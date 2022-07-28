package com.binance4j.margin.dto;

import java.util.List;

/**
 * Isolated margin transfer records
 * 
 * @param rows  The transfers.
 * @param total The total records.
 */
public record IsolatedTransferRecords(
		/** The transfers. */
		List<IsolatedTransferRecord> rows,
		/** The total records. */
		int total) {
}