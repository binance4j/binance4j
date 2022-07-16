package com.binance4j.margin.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public record IsolatedAsset(
		/** The asset name. */
		String asset,
		/** The borrowed quantity. */
		BigDecimal borrowed,
		/** The free quantity. */
		BigDecimal free,
		/** The loan interest. */
		BigDecimal interest,
		/** The locked quantity. */
		BigDecimal locked,
		/** The net asset quantity. */
		BigDecimal netAsset,
		/** The net asset of Bitcoin. */
		BigDecimal netAssetOfBtc,
		/** The asset total quantity. */
		BigDecimal totalAsset,
		/** Can the account borrow this asset? */
		boolean borrowEnabled,
		/** Can the account repay this asset? */
		boolean repayEnabled) {
}