package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A NFT Deposit
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 * @param txID            Transaction ID.
 * @param timestamp       Deposit time in ms.
 */
@ApiModel("")
public record Deposit(@ApiModelProperty("") String network, @ApiModelProperty("") String contractAddress, @ApiModelProperty("") String tokenId,
		@ApiModelProperty("") String txID, @ApiModelProperty("") long timestamp) {
}