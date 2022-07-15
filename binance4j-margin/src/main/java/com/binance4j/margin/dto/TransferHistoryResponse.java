package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransferHistoryResponse(
		/** TODO JAVADOC. */
		int total,
		/** TODO JAVADOC. */
		List<MarginTransferHistory> rows) {
}