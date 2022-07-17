package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A NFT
 * 
 * @param network         NFT Network.
 * @param tokenId         NFT Token ID.
 * @param contractAddress NFT Contract Address.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record NFT(
		/** NFT Network. */
		String network,
		/** NFT Token ID. */
		String tokenId,
		/** NFT Contract Address. */
		String contractAddress) {
}
