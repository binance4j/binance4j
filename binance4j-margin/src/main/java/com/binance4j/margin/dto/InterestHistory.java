package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InterestHistory(
		/** TODO JAVADOC. */
		Integer total,
		/** TODO JAVADOC. */
		List<InterestData> rows) {
}