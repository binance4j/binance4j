package com.binance4j.nft.dto;

/**
 * A NFT
 * 
 * @param network         NFT Network.
 * @param tokenId         NFT Token ID.
 * @param contractAddress NFT Contract Address.
 */
public record NFT(
		/** NFT Network. */
		String network,
		/** NFT Token ID. */
		String tokenId,
		/** NFT Contract Address. */
		String contractAddress) {
}
