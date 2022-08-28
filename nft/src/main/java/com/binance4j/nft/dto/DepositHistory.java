package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT deposit history.
 * 
 * @property total Total records.
 * @property list  Transactions.
 */
@ApiModel("NFT deposit history.")
data class DepositHistory(
@ApiModelProperty("Total records.")
var total:Long?=null,
@ApiModelProperty("Transactions.") List<Deposit> list)
{
}
