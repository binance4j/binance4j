package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT asset.
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 */
@ApiModel("NFT asset.")
public record Asset(@ApiModelProperty("NFT Network.") String network,
		@ApiModelProperty("NFT Contract Address.") String contractAddress,
		@ApiModelProperty("NFT Token ID.") String tokenId) {
}
