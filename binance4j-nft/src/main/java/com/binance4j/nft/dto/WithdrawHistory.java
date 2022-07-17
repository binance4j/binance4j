package com.binance4j.nft.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A NFT withdraw history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record WithdrawHistory(
		/** Total records. */
		long total,
		/** The transactions. */
		List<Withdraw> list) {
}
