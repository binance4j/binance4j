package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT asset.
 * 
 * @property network         NFT Network.
 * @property contractAddress NFT Contract Address.
 * @property tokenId         NFT Token ID.
 */
@ApiModel("NFT asset.")
data class Asset(
@ApiModelProperty("NFT Network.")
var network:String?=null,
@ApiModelProperty("NFT Contract Address.")
var contractAddress:String?=null,
@ApiModelProperty("NFT Token ID.")
var tokenId:String?=null)
{
}
