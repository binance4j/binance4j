package com.binance4j.wallet.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** An asset divident */
@JsonIgnoreProperties(ignoreUnknown = true)
public record AssetDividend(
		/** The divident amount. */
		BigDecimal amount,
		/** TODO JAVADOC */
		String enInfo,
		/** The asset abbreviation. */
		String asset,
		/** The id. */
		long id,
		/** TODO JAVADOC */
		long divTime,
		/** The transaction id. */
		long tranId) {
}