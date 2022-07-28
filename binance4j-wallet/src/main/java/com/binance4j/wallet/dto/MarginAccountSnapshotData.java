package com.binance4j.wallet.dto;

import java.util.List;

/** Margin account snapshot data. */
public record MarginAccountSnapshotData(
		/** Margin level. */
		String marginLevel,
		/** Total asset of Bitcoin. */
		String totalAssetOfBtc,
		/** Total liability Of Bitcoin. */
		String totalLiabilityOfBtc,
		/** Total net Asset of Bitcoin. */
		String totalNetAssetOfBtc,
		/** User assets. */
		List<MarginAccountSnapshotUserAssets> userAssetss) {
}