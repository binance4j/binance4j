package com.binance4j.nft.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A NFT Withdraw.
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param transactionId   Transaction ID.
 * @param timestamp       Deposit time in ms.
 * @param fee             The withdraw fee.
 * @param feeAsset        The fee asset.
 */
public record NFTWithdraw(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId,
		/** Transaction ID. */
		@JsonProperty("txID") String transactionId,
		/** Deposit time in ms. */
		long timestamp,
		/** The withdraw fee. */
		BigDecimal fee,
		/** The fee asset. */
		String feeAsset) {
}
