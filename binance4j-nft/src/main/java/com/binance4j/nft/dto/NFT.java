package com.binance4j.nft.dto;

/**
 * A NFT
 * 
 * @param network         NFT Network.
 * @param tokenId         NFT Token ID.
 * @param contractAddress NFT Contract Address.
 */
public record NFT(String network, String tokenId, String contractAddress) {
}
