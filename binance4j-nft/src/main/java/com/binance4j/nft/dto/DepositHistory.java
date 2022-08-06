package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A NFT deposit history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
@ApiModel("")
public record DepositHistory(@ApiModelProperty("") long total, @ApiModelProperty("") List<Deposit> list) {
}
