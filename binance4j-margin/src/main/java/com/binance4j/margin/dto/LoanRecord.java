package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** History of account withdrawals. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LoanRecord(
		/** TODO JAVADOC. */
		@JsonProperty("totalclas") int total,
		/** TODO JAVADOC. */
		@JsonProperty("rowsclas") List<Loan> rows) {
}