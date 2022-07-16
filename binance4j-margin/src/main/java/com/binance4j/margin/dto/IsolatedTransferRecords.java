package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated margin transfer records
 * 
 * @param rows  The transfers.
 * @param total The total records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTransferRecords(
		/** The transfers. */
		List<IsolatedTransferRecord> rows,
		/** The total records. */
		int total) {
}