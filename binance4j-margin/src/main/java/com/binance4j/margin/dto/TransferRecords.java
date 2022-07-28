package com.binance4j.margin.dto;

import java.util.List;

/**
 * A list of transfer history records
 * 
 * @param total The total of records.
 * @param rows  The records.
 */
public record TransferRecords(
		/** The total of records. */
		int total,
		/** The records. */
		List<TransferRecord> rows) {
}