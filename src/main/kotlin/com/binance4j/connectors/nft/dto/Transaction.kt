/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.nft.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * NFT transaction.
 *
 * @property orderNo       Order number. 0: purchase order 1: sell order 2: royalty income 3: primary market order 4: mint fee
 * @property tokens        Tokens.
 * @property tradeTime     Trade time in ms.
 * @property tradeAmount   Trade amount.
 * @property tradeCurrency Currency used to buy the NFT.
 */
@ApiModel("NFT transaction.")
data class Transaction(
	@ApiModelProperty("Order number. 0: purchase order 1: sell order 2: royalty income 3: primary market order 4: mint fee")
	@JsonProperty("orderNo")
	var orderNo: String,
	@ApiModelProperty("Tokens.")
	@JsonProperty("tokens")
	var tokens: List<NFT>,
	@ApiModelProperty("Trade time in ms.")
	@JsonProperty("tradeTime")
	var tradeTime: Long,
	@ApiModelProperty("Trade amount.")
	@JsonProperty("tradeAmount")
	var tradeAmount: String,
	@ApiModelProperty("Currency used to buy the NFT.")
	@JsonProperty("tradeCurrency")
	var tradeCurrency: String
)