package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** A NFT Deposit */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTDeposit(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId,
		/** Transaction ID. */
		@JsonProperty("txID") String transactionId,
		/** Deposit time in ms. */
		Long timestamp) {
}