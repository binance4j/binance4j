package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Trade(
		/** TODO JAVADOC. */
		String symbol,
		/** TODO JAVADOC. */
		String commissionAsset,
		/** TODO JAVADOC. */
		BigDecimal commission,
		/** TODO JAVADOC. */
		BigDecimal price,
		/** TODO JAVADOC. */
		@JsonProperty("qty") BigDecimal quantity,
		/** TODO JAVADOC. */
		long id,
		/** TODO JAVADOC. */
		long orderId,
		/** TODO JAVADOC. */
		long time,
		/** TODO JAVADOC. */
		boolean isBestMatch,
		/** TODO JAVADOC. */
		boolean isBuyer,
		/** TODO JAVADOC. */
		boolean isMaker,
		/** TODO JAVADOC. */
		boolean isIsolated) {
}