package com.binance4j.nft.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A NFT deposit history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTDepositHistory(
		/** Total records. */
		long total,
		/** The transactions. */
		List<NFTDeposit> list) {
}
