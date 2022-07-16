package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A list of transfer history records
 * 
 * @param total The total of records.
 * @param rows  The records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TransferRecords(
		/** The total of records. */
		int total,
		/** The records. */
		List<TransferRecord> rows) {
}