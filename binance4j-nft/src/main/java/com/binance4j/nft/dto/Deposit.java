package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A NFT Deposit
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param transactionId   Transaction ID.
 * @param timestamp       Deposit time in ms.
 */
public record Deposit(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId,
		/** Transaction ID. */
		@JsonProperty("txID") String transactionId,
		/** Deposit time in ms. */
		long timestamp) {
}