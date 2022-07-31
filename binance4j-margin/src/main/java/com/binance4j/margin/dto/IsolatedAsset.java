package com.binance4j.margin.dto;

/**
 * Isolated asset in {@link IsolatedPair}
 * 
 * @param asset         The asset name.
 * @param borrowEnabled The borrowed quantity.
 * @param repayEnabled  The free quantity.
 * @param borrowed      The loan interest.
 * @param free          The locked quantity.
 * @param interest      The net asset quantity.
 * @param locked        The net asset of Bitcoin.
 * @param netAsset      The asset total quantity.
 * @param netAssetOfBtc Can the account borrow this asset?
 * @param totalAsset    Can the account repay this asset?
 */
public record IsolatedAsset(String asset, String borrowed, String free, String interest, String locked, String netAsset, String netAssetOfBtc,
		String totalAsset, boolean borrowEnabled, boolean repayEnabled) {
}