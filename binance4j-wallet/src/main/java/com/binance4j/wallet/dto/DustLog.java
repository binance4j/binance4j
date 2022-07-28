package com.binance4j.wallet.dto;

import java.util.List;

/**
 * Logs of assets converted in BNB.
 * 
 * @param total              Total counts of exchange.
 * @param userAssetDribblets Dribblets.
 */
public record DustLog(
		/** Total counts of exchange. */
		int total,
		/** Dribblets. */
		List<UserAssetDribblets> userAssetDribblets) {
}
