package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** Logs of assets converted in BNB */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DustLog(
		/** Total counts of exchange. */
		int total,
		/** TODO JAVADOC */
		List<DustLogUserAssetDribblets> userAssetDribblets) {
}
