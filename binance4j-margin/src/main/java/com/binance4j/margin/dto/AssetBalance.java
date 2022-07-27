package com.binance4j.margin.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Asset balance of an {@link Account}.
 * 
 * @param asset    The asset name.
 * @param borrowed The borrowed quantity.
 * @param free     The free quantity.
 * @param interest The borrow interest.
 * @param locked   The locked quantity.
 * @param netAsset The net asset.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetBalance(
		/** The asset name. */
		String asset,
		/** The borrowed quantity. */
		String borrowed,
		/** The free quantity. */
		String free,
		/** The borrow interest. */
		String interest,
		/** The locked quantity. */
		String locked,
		/** The net asset. */
		String netAsset) {
}