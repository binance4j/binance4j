package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT asset
 * 
 * @param network         NFT Network.
 * @param contractAddress NFT Contract Address.
 * @param tokenId         NFT Token ID.
 */
@ApiModel("")
public record Asset(@ApiModelProperty("") String network, @ApiModelProperty("") String contractAddress, @ApiModelProperty("") String tokenId) {
}
