package com.binance4j.wallet.dto;

import java.util.List;

/**
 * Assets that can be converted into BNB.
 * 
 * @param details            Details.
 * @param totalTransferBtc   The BTC valuation.
 * @param totalTransferBNB   The BNB valuation.
 * @param dribbletPercentage The commission fee.
 */
public record ConvertibleAssets(
		/** Details. */
		List<ConvertibleAsset> details,
		/** The BTC valuation. */
		String totalTransferBtc,
		/** The BNB valuation. */
		String totalTransferBNB,
		/** The commission fee. */
		String dribbletPercentage) {
}
