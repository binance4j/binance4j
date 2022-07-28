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
public record IsolatedAsset(
		/** The asset name. */
		String asset,
		/** The borrowed quantity. */
		String borrowed,
		/** The free quantity. */
		String free,
		/** The loan interest. */
		String interest,
		/** The locked quantity. */
		String locked,
		/** The net asset quantity. */
		String netAsset,
		/** The net asset of Bitcoin. */
		String netAssetOfBtc,
		/** The asset total quantity. */
		String totalAsset,
		/** Can the account borrow this asset? */
		boolean borrowEnabled,
		/** Can the account repay this asset? */
		boolean repayEnabled) {
}