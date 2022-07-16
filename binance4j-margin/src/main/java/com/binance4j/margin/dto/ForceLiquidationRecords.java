package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A {@link ForceLiquidationRecord} records container
 * 
 * @param rows  The records.
 * @param total The total number of records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidationRecords(
		/** The records. */
		List<ForceLiquidationRecord> rows,
		/** The total number of records. */
		int total) {
}