package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT withdraw history.
 * 
 * @property total Total records.
 * @property list  Transactions.
 */
@ApiModel("NFT withdraw history.")
data class AssetHistory(
@ApiModelProperty("Total records.")
@JsonProperty("total") var total:Long?=null,
@ApiModelProperty("Transactions.") List<Asset> list)
{
}
