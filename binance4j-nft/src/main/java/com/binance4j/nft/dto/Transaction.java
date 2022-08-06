package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT transaction.
 * 
 * @param orderNo       Order number. 0: purchase order 1: sell order 2: royalty income 3: primary market order 4: mint
 *                          fee
 * @param tokens        Tokens.
 * @param tradeTime     Trade time in ms.
 * @param tradeAmount   Trade amount.
 * @param tradeCurrency Currency used to buy the NFT.
 */
@ApiModel("NFT transaction.")
public record Transaction(
		@ApiModelProperty("Order number. 0: purchase order 1: sell order 2: royalty income 3: primary market order 4: mint fee") String orderNo,
		@ApiModelProperty("Tokens.") List<NFT> tokens, @ApiModelProperty("Trade time in ms.") long tradeTime,
		@ApiModelProperty("Trade amount.") String tradeAmount, @ApiModelProperty("Currency used to buy the NFT.") String tradeCurrency) {
}
