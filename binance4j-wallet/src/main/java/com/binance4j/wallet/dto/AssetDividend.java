package com.binance4j.wallet.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * An asset divident.
 * 
 * @param amount  The divident amount.
 * @param enInfo  Info about the asset.
 * @param asset   The asset abbreviation.
 * @param id      The id.
 * @param divTime Dividend time in ms.
 * @param tranId  The transaction id.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetDividend(
		/** The divident amount. */
		String amount,
		/** Info about the asset. */
		String enInfo,
		/** The asset abbreviation. */
		String asset,
		/** The id. */
		long id,
		/** Dividend time in ms. */
		long divTime,
		/** The transaction id. */
		long tranId) {
}