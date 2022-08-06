package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT withdraw history.
 * 
 * @param total Total records.
 * @param list  Transactions.
 */
@ApiModel("NFT withdraw history.")
public record AssetHistory(@ApiModelProperty("Total records.") long total, @ApiModelProperty("Transactions.") List<Asset> list) {
}
