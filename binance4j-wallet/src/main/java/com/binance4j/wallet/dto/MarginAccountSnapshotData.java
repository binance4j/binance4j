package com.binance4j.wallet.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Margin account snapshot data. */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginAccountSnapshotData(
		/** Margin level. */
		BigDecimal marginLevel,
		/** Total asset of Bitcoin. */
		BigDecimal totalAssetOfBtc,
		/** Total liability Of Bitcoin. */
		BigDecimal totalLiabilityOfBtc,
		/** Total net Asset of Bitcoin. */
		BigDecimal totalNetAssetOfBtc,
		/** User assets. */
		List<MarginAccountSnapshotUserAssets> userAssetss) {
}