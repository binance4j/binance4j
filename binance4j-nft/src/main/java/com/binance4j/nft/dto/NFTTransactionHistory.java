package com.binance4j.nft.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A NFT transaction history */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTTransactionHistory(
		/** total records. */
		Long total,
		/** The transactions. */
		List<NFTTransaction> list) {
}
