package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT Deposit.
 * 
 * @property network         NFT Network.
 * @property contractAddress NFT Contract Address.
 * @property tokenId         NFT Token ID.
 * @property txID            Transaction ID.
 * @property timestamp       Deposit time in ms.
 */
@ApiModel("NFT Deposit.")
data class Deposit(
@ApiModelProperty("NFT Network.")
var network:String?=null,
@ApiModelProperty("NFT Contract Address.")
var contractAddress:String?=null,
@ApiModelProperty("NFT Token ID.")
var tokenId:String?=null,
@ApiModelProperty("Transaction ID.")
var txID:String?=null,
@ApiModelProperty("Deposit time in ms.") var timestamp:Long?=null)
{
}