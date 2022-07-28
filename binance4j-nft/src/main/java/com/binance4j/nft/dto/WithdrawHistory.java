package com.binance4j.nft.dto;

import java.util.List;

/**
 * A NFT withdraw history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
public record WithdrawHistory(
		/** Total records. */
		long total,
		/** The transactions. */
		List<Withdraw> list) {
}
