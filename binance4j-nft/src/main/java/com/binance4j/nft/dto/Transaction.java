package com.binance4j.nft.dto;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * NFT transaction
 * 
 * @param orderNo       The Order number.
 *                          <ul>
 *                          <li>0: purchase order</li>
 *                          <li>1: sell order</li>
 *                          <li>2: royalty income</li>
 *                          <li>3: primary market order</li>
 *                          <li>4: mint fee</li>
 *                          </ul>
 * @param tokens        The tokens.
 * @param tradeTime     The trade time in ms.
 * @param tradeAmount   The trade amount.
 * @param tradeCurrency The currency used to buy the NFT.
 */
@ApiModel("")
public record Transaction(@ApiModelProperty("")
/**
 * The Order number.
 * <ul>
 * <li>0: purchase order</li>
 * <li>1: sell order</li>
 * <li>2: royalty income</li>
 * <li>3: primary market order</li>
 * <li>4: mint fee</li>
 * </ul>
 */
String orderNo, @ApiModelProperty("") List<NFT> tokens, @ApiModelProperty("") long tradeTime, @ApiModelProperty("") String tradeAmount,
		@ApiModelProperty("") String tradeCurrency) {
}
