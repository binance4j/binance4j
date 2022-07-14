package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ForceLiquidationRecord(
		/** TODO JAVADOC. */
		List<ForceLiquidation> rows,
		/** TODO JAVADOC. */
		Integer total) {
}
