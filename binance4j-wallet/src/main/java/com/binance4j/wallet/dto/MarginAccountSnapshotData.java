package com.binance4j.wallet.dto;

import java.util.List;

/** Margin account snapshot data. */
public record MarginAccountSnapshotData(String marginLevel, String totalAssetOfBtc, String totalLiabilityOfBtc, String totalNetAssetOfBtc,
		List<MarginAccountSnapshotUserAssets> userAssetss) {
}