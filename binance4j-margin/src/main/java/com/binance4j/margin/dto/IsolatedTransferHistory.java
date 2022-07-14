package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedTransferHistory(
		/** TODO JAVADOC. */
		List<IsolatedTransfer> rows,
		/** TODO JAVADOC. */
		int total) {
}