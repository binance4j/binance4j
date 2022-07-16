package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Interest History containing {@link InterestRecord InterestRecords}
 * 
 * @param total The total number of records.
 * @param rows  The interest records.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestHistory(
		/** The total number of records. */
		int total,
		/** The interest records. */
		List<InterestRecord> rows) {
}