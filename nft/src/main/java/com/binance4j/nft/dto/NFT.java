package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT asset.
 * 
 * @property network         NFT Network.
 * @property tokenId         NFT Token ID.
 * @property contractAddress NFT Contract Address.
 */
@ApiModel("NFT asset.")
data class NFT(
@ApiModelProperty("NFT Network.")
@JsonProperty("network") var network:String?=null,
@ApiModelProperty("NFT Token ID.")
@JsonProperty("tokenId") var tokenId:String?=null,
@ApiModelProperty("NFT Contract Address.")
@JsonProperty("contractAddress") var contractAddress:String?=null)
{
}
