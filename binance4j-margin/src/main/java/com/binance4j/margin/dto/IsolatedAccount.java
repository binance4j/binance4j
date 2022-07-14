package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccount(
		/** TODO JAVADOC. */
		List<IsolatedAssets> assets,
		/** TODO JAVADOC. */
		BigDecimal totalAssetOfBtc,
		/** TODO JAVADOC. */
		BigDecimal totalLiabilityOfBtc,
		/** TODO JAVADOC. */
		BigDecimal totalNetAssetOfBtc) {
}
