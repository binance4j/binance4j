package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel("")
public record Withdraw(@ApiModelProperty("") String network, @ApiModelProperty("") String contractAddress, @ApiModelProperty("") String tokenId,
		@ApiModelProperty("") String txID, @ApiModelProperty("") long timestamp, @ApiModelProperty("") String fee, @ApiModelProperty("") String feeAsset) {
}
