package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The authenticated margin account
 * 
 * @param userAssets          The user assets.
 * @param marginLevel         The margin level.
 * @param totalAssetOfBtc     The total asset of Bitcoin.
 * @param totalLiabilityOfBtc The total liability of Bitcoin.
 * @param totalNetAssetOfBtc  The total net asset of Bitcoin.
 * @param borrowEnabled       Is borrow enabled?
 * @param tradeEnabled        Is trade enabled?
 * @param transferEnabled     Is transfer Enabled?
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		/** The user assets. */
		List<AssetBalance> userAssets,
		/** The margin level. */
		String marginLevel,
		/** The total asset of Bitcoin. */
		String totalAssetOfBtc,
		/** The total liability of Bitcoin. */
		String totalLiabilityOfBtc,
		/** The total net asset of Bitcoin. */
		String totalNetAssetOfBtc,
		/** Is borrow enabled? */
		boolean borrowEnabled,
		/** Is trade enabled? */
		boolean tradeEnabled,
		/** Is transfer Enabled? */
		boolean transferEnabled) {
}