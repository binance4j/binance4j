package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An asset divident record.
 * 
 * @param rows  The records.
 * @param total The number of record.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetDividendRecord(
		/** The records. */
		List<AssetDividend> rows,
		/** The number of record. */
		long total) {
}
