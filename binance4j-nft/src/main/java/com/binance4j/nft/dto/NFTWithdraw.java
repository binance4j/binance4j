package com.binance4j.nft.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/** A NFT Withdraw */
public record NFTWithdraw(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId,
		/** Transaction ID. */
		@JsonProperty("txID") String transactionId, /** Deposit time in ms. */
		long timestamp,
		/** The withdraw fee. */
		BigDecimal fee,
		/** The fee asset. */
		String feeAsset) {
}
