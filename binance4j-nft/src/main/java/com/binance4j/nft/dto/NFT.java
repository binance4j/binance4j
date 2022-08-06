package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A NFT
 * 
 * @param network         NFT Network.
 * @param tokenId         NFT Token ID.
 * @param contractAddress NFT Contract Address.
 */
@ApiModel("")
public record NFT(@ApiModelProperty("") String network, @ApiModelProperty("") String tokenId, @ApiModelProperty("") String contractAddress) {
}
