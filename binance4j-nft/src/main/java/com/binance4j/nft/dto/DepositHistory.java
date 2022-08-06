package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT deposit history.
 * 
 * @param total Total records.
 * @param list  Transactions.
 */
@ApiModel("NFT deposit history.")
public record DepositHistory(@ApiModelProperty("Total records.") long total, @ApiModelProperty("Transactions.") List<Deposit> list) {
}
