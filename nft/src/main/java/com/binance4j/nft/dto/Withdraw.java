package com.binance4j.nft.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT Withdraw.
 * 
 * @property network         NFT Network.
 * @property contractAddress NFT Contract Address.
 * @property tokenId         NFT Token ID.
 * @property txID            Transaction ID.
 * @property timestamp       Deposit time in ms.
 * @property fee             Withdraw fee.
 * @property feeAsset        Fee asset.
 */
@ApiModel("NFT Withdraw.")
data class Withdraw(
@ApiModelProperty("NFT Network.")
var network:String?=null,
@ApiModelProperty("NFT Contract Address.")
var contractAddress:String?=null,
@ApiModelProperty("NFT Token ID.")
var tokenId:String?=null,
@ApiModelProperty("Transaction ID.")
var txID:String?=null,
@ApiModelProperty("Deposit time in ms.")
var timestamp:Long?=null,
@ApiModelProperty("Withdraw fee.")
var fee:String?=null,
@ApiModelProperty("Fee asset.")
var feeAsset:String?=null)
{
}
