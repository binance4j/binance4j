package com.binance4j.margin.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		/** The user assets. */
		List<AssetBalance> userAssets,
		/** The margin level. */
		BigDecimal marginLevel,
		/** The total asset of Bitcoin. */
		BigDecimal totalAssetOfBtc,
		/** The total liability of Bitcoin. */
		BigDecimal totalLiabilityOfBtc,
		/** The total net asset of Bitcoin */
		BigDecimal totalNetAssetOfBtc,
		/** Is borrow enabled? */
		boolean borrowEnabled,
		/** Is trade enabled? */
		boolean tradeEnabled,
		/** Is transfer Enabled? */
		boolean transferEnabled) {
}