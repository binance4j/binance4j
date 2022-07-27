package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Isolated margin account info
 * 
 * @param assets              The owned assets.
 * @param totalAssetOfBtc     Total asset of Bitcoin.
 * @param totalLiabilityOfBtc Total liability of Bitcoin.
 * @param totalNetAssetOfBtc  Total net asset of Bitcoin.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAccount(
		/** The owned assets. */
		List<IsolatedPair> assets,
		/** Total asset of Bitcoin. */
		String totalAssetOfBtc,
		/** Total liability of Bitcoin. */
		String totalLiabilityOfBtc,
		/** Total net asset of Bitcoin. */
		String totalNetAssetOfBtc) {
}