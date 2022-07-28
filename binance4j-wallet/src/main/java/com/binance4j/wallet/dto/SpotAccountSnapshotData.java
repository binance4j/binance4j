package com.binance4j.wallet.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

/**
 * The SPOT account snapshot data.
 * 
 * @param balances        The wallet asset balances.
 * @param totalAssetOfBtc The cumulated value of the wallet in Bitcoin.
 */
public record SpotAccountSnapshotData(
		/** The wallet asset balances. */
		List<AssetBalance> balances,
		/** The cumulated value of the wallet in Bitcoin. */
		String totalAssetOfBtc) {
}