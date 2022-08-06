package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT asset.
 * 
 * @param network         NFT Network.
 * @param tokenId         NFT Token ID.
 * @param contractAddress NFT Contract Address.
 */
@ApiModel("NFT asset.")
public record NFT(@ApiModelProperty("NFT Network.") String network, @ApiModelProperty("NFT Token ID.") String tokenId,
		@ApiModelProperty("NFT Contract Address.") String contractAddress) {
}
