package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** History of account withdrawals. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RepayRecord(
		/** TODO JAVADOC. */
		int total,
		/** TODO JAVADOC. */
		List<Repay> rows) {
}