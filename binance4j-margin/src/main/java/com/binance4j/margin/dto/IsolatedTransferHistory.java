package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated margin transfer history
 * 
 * @param rows  The transfers.
 * @param total The total records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTransferHistory(
		/** The transfers. */
		List<IsolatedTransfer> rows,
		/** The total records. */
		int total) {
}