package com.binance4j.margin.dto;

import java.util.List;

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
public record Account(List<AssetBalance> userAssets, String marginLevel, String totalAssetOfBtc, String totalLiabilityOfBtc, String totalNetAssetOfBtc,
		boolean borrowEnabled, boolean tradeEnabled, boolean transferEnabled) {
}