package com.binance4j.nft.dto;

/**
 * A NFT Withdraw.
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param txID            Transaction ID.
 * @param timestamp       Deposit time in ms.
 * @param fee             The withdraw fee.
 * @param feeAsset        The fee asset.
 */
public record Withdraw(String network, String contractAddress, String tokenId, String txID, long timestamp, String fee, String feeAsset) {
}
