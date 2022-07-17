package com.binance4j.nft.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record NFT(
		/** NFT Network. */
		String network,
		/** NFT Token ID. */
		String tokenId,
		/** NFT Contract Address. */
		String contractAddress) {
}
