package com.binance4j.nft.dto;

/**
 * A NFT Deposit
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param txID            Transaction ID.
 * @param timestamp       Deposit time in ms.
 */
public record Deposit(String network, String contractAddress, String tokenId, String txID, long timestamp) {
}