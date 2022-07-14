package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccountLimit(
		/** TODO JAVADOC. */
		int enabledAccount,
		/** TODO JAVADOC. */
		int maxAccount) {
}
