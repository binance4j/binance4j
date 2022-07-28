package com.binance4j.nft.dto;

import java.util.List;

/**
 * A NFT transaction history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
public record TransactionHistory(
		/** Total records. */
		long total,
		/** The transactions. */
		List<Transaction> list) {
}
