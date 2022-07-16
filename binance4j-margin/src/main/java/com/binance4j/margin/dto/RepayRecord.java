package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A repay record.
 * 
 * @param total The total of repays.
 * @param rows  The repays.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RepayRecord(
		/** The total of repays. */
		int total,
		/** The repays. */
		List<Repay> rows) {
}