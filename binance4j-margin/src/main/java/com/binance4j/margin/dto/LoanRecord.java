package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A loan record.
 * 
 * @param total The total records.
 * @param rows  The records.
 */
public record LoanRecord(
		/** The total number of loans. */
		@JsonProperty("totalclas") int total,
		/** The loans. */
		@JsonProperty("rowsclas") List<Loan> rows) {
}