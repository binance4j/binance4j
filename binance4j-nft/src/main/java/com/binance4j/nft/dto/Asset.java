package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * NFT asset
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Asset(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId) {
}
