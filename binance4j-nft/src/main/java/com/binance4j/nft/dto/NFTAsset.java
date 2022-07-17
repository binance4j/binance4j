package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NFTAsset(
		/** NFT Network. */
		String network,
		/** NFT Contract Address. */
		String contractAddress,
		/** NFT Token ID. */
		String tokenId) {
}
