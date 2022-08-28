package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT transaction history.
 * 
 * @property total Total records.
 * @property list  Transactions.
 */
@ApiModel("NFT transaction history.")
data class TransactionHistory(
@ApiModelProperty("Total records.")
var total:Long?=null,
@ApiModelProperty("Transactions.") List<Transaction> list)
{
}
