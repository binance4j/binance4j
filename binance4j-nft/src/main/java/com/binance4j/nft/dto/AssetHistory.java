package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A NFT withdraw history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
@ApiModel("")
public record AssetHistory(@ApiModelProperty("") long total, @ApiModelProperty("") List<Asset> list) {
}
