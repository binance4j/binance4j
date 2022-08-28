package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT transaction.
 * 
 * @property orderNo       Order number. 0: purchase order 1: sell order 2: royalty
 *                      income 3: primary market order 4: mint
 *                      fee
 * @property tokens        Tokens.
 * @property tradeTime     Trade time in ms.
 * @property tradeAmount   Trade amount.
 * @property tradeCurrency Currency used to buy the NFT.
 */
@ApiModel("NFT transaction.")
data class Transaction(
		@ApiModelProperty("Order number. 0: purchase order 1: sell order 2: royalty income 3: primary market order 4: mint fee") String orderNo,
		@ApiModelProperty("Tokens.") List<NFT> tokens, @ApiModelProperty("Trade time in ms.") var tradeTime : Long? = null,
		@ApiModelProperty("Trade amount.") var tradeAmount : String? = null,
		@ApiModelProperty("Currency used to buy the NFT.") var tradeCurrency : String? = null) {
}
