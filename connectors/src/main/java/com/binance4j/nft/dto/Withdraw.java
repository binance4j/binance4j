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
@JsonProperty("network") var network: String = "",
@ApiModelProperty("NFT Contract Address.")
@JsonProperty("contractAddress") var contractAddress: String = "",
@ApiModelProperty("NFT Token ID.")
@JsonProperty("tokenId") var tokenId: String = "",
@ApiModelProperty("Transaction ID.")
@JsonProperty("txID") var txID: String = "",
@ApiModelProperty("Deposit time in ms.")
@JsonProperty("timestamp") var timestamp: Long = 0L,
@ApiModelProperty("Withdraw fee.")
@JsonProperty("fee") var fee: String = "",
@ApiModelProperty("Fee asset.")
@JsonProperty("feeAsset") var feeAsset: String = "")
{
}
