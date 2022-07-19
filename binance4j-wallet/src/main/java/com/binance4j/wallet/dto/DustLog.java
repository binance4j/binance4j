package com.binance4j.wallet.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Logs of assets converted in BNB.
 * 
 * @param total              Total counts of exchange.
 * @param userAssetDribblets Dribblets.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record DustLog(
		/** Total counts of exchange. */
		int total,
		/** Dribblets. */
		List<UserAssetDribblets> userAssetDribblets) {
}
