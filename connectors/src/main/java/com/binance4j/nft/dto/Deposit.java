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
@JsonProperty("network") var network: String = "",
@ApiModelProperty("NFT Contract Address.")
@JsonProperty("contractAddress") var contractAddress: String = "",
@ApiModelProperty("NFT Token ID.")
@JsonProperty("tokenId") var tokenId: String = "",
@ApiModelProperty("Transaction ID.")
@JsonProperty("txID") var txID: String = "",
@ApiModelProperty("Deposit time in ms.") @JsonProperty("timestamp") var timestamp: Long = 0L)
{
}