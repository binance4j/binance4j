package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT Withdraw.
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param txID            Transaction ID.
 * @param timestamp       Deposit time in ms.
 * @param fee             Withdraw fee.
 * @param feeAsset        Fee asset.
 */
@ApiModel("NFT Withdraw.")
public record Withdraw(@ApiModelProperty("NFT Network.") String network,
		@ApiModelProperty("NFT Contract Address.") String contractAddress,
		@ApiModelProperty("NFT Token ID.") String tokenId, @ApiModelProperty("Transaction ID.") String txID,
		@ApiModelProperty("Deposit time in ms.") long timestamp, @ApiModelProperty("Withdraw fee.") String fee,
		@ApiModelProperty("Fee asset.") String feeAsset) {
}
