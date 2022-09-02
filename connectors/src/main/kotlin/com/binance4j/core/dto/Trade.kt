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

package com.binance4j.core.dto

import com.fasterxml.jackson.annotation.JsonIncludeProperties
import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An executed trade.
 *
 * @property id Trade id.
 * @property price Price.
 * @property qty Quantity.
 * @property quoteQty Quote quantity for the trade (price * qty).
 * @property commission Commission.
 * @property commissionAsset Asset on which commission is taken.
 * @property time Trade execution time.
 * @property symbol Symbol of the trade.
 * @property orderId Order id.
 * @property orderListId Order list id.
 * @property isBuyer Is buyer trade.
 * @property isMaker Is maker trade.
 * @property isBestMatch Is best match?
 */
@ApiModel("An executed trade.")
@JsonIncludeProperties
data class Trade(
	@ApiModelProperty("Trade id.")
	var id: Long,
	@ApiModelProperty("Price.")
	var price: String,
	@ApiModelProperty("Quantity.")
	var qty: String,
	@ApiModelProperty("Quote quantity for the trade (price * qty).")
	@JsonProperty
	var quoteQty: String,
	@ApiModelProperty("Commission.")
	var commission: String,
	@ApiModelProperty("Asset on which commission is taken.")
	@JsonProperty
	var commissionAsset: String,
	@ApiModelProperty("Trade execution time.")
	var time: Long,
	@ApiModelProperty("The symbol of the trade.")
	var symbol: String,
	@ApiModelProperty("The order id.")
	var orderId: String,
	@ApiModelProperty("The order list id.")
	var orderListId: String,
	@ApiModelProperty("Is buyer trade.")
	var isBuyer: Boolean,
	@ApiModelProperty("Is maker trade.")
	var isMaker: Boolean,
	@ApiModelProperty("Is best match?")
	var isBestMatch: Boolean
)