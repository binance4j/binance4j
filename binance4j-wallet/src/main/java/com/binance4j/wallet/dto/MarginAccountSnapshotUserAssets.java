package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Margin account snapshot user assets.
 * 
 * @param asset    The asset abbreviation
 * @param borrowed The borrowed amount
 * @param free     The fee amount
 * @param interest The interest amount
 * @param locked   The locked volume
 * @param netAsset Net asset
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record MarginAccountSnapshotUserAssets(
		/** The asset abbreviation **/
		String asset,
		/** The borrowed amount **/
		String borrowed,
		/** The fee amount **/
		String free,
		/** The interest amount **/
		String interest,
		/** The locked volume **/
		String locked,
		/** Net asset **/
		String netAsset) {
}