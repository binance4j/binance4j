package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A {@link ForceLiquidation} record
 * 
 * @param rows  The records.
 * @param total The total number of records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidationRecord(
		/** The records. */
		List<ForceLiquidation> rows,
		/** The total number of records. */
		int total) {
}