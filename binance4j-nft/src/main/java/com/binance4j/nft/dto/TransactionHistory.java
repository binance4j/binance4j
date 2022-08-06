package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A NFT transaction history
 * 
 * @param total Total records.
 * @param list  The transactions.
 */
@ApiModel("")
public record TransactionHistory(@ApiModelProperty("") long total, @ApiModelProperty("") List<Transaction> list) {
}
