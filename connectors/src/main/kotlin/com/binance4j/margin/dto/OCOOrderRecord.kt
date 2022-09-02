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

package com.binance4j.margin.dto

import com.fasterxml.jackson.annotation.JsonProperty

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An OCO order record.
 *
 * @property orderListId       Order list id.
 * @property transactionTime   Transaction timestamp in ms.
 * @property symbol            Related symbol.
 * @property contingencyType   Contingency type.
 * @property listStatusType    List status type.
 * @property listOrderStatus   List order status.
 * @property listClientOrderId List client order id.
 * @property isIsoslated       Is the order isolated?
 * @property orders            Two orders.
 */
@ApiModel("An OCO order record.")
data class OCOOrderRecord(
	@ApiModelProperty("Order list id.")
	@JsonProperty("orderListId")
	var orderListId: Long,
	@ApiModelProperty("Transaction timestamp in ms.")
	@JsonProperty("transactionTime")
	var transactionTime: Long,
	@ApiModelProperty("Related symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("Contingency type.")
	@JsonProperty("contingencyType")
	var contingencyType: String,
	@ApiModelProperty("List status type.")
	@JsonProperty("listStatusType")
	var listStatusType: String,
	@ApiModelProperty("List order status.")
	@JsonProperty("listOrderStatus")
	var listOrderStatus: String,
	@ApiModelProperty("List client order id.")
	@JsonProperty("listClientOrderId")
	var listClientOrderId: String,
	@ApiModelProperty("Is the order isolated?")
	@JsonProperty("isIsoslated")
	var isIsoslated: Boolean,
	@ApiModelProperty("The two orders.")
	@JsonProperty("orders")
	var orders: List<OrderInfo>
)

