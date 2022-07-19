package com.binance4j.wallet.dto;

import java.math.BigDecimal;

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
		BigDecimal borrowed,
		/** The fee amount **/
		BigDecimal free,
		/** The interest amount **/
		BigDecimal interest,
		/** The locked volume **/
		BigDecimal locked,
		/** Net asset **/
		BigDecimal netAsset) {
}