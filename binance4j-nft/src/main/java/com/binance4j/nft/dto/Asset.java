package com.binance4j.nft.dto;

/**
 * NFT asset
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 */
public record Asset(String network, String contractAddress, String tokenId) {
}
