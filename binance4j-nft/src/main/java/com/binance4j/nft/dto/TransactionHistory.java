package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT transaction history.
 * 
 * @param total Total records.
 * @param list  Transactions.
 */
@ApiModel("NFT transaction history.")
public record TransactionHistory(@ApiModelProperty("Total records.") long total, @ApiModelProperty("Transactions.") List<Transaction> list) {
}
