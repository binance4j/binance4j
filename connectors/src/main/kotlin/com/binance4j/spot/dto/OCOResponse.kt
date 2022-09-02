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

package com.binance4j.spot.dto

import com.fasterxml.jackson.annotation.JsonProperty

import com.binance4j.core.dto.MiniOrderInfo

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * Response of an OCO order.
 *
 * @property orderListId       Order list id.
 * @property contingencyType   Contingency type.
 * @property listStatusType    List status.
 * @property listOrderStatus   List order status.
 * @property listClientOrderId List client order id.
 * @property transactionTime   Order timestamp.
 * @property symbol            Order symbol.
 * @property orders            The 2 orders.
 * @property isIsolated        Is it an isolated trade?
 * @property orderReports      Order reports.
 */
@ApiModel("Response of an OCO order.")
data class OCOResponse(
	@ApiModelProperty("Order list id.")
	@JsonProperty("orderListId")
	var orderListId: Long,
	@ApiModelProperty("Contingency type.")
	@JsonProperty("contingencyType")
	var contingencyType: String,
	@ApiModelProperty("List status.")
	@JsonProperty("listStatusType")
	var listStatusType: String,
	@ApiModelProperty("List order status.")
	@JsonProperty("listOrderStatus")
	var listOrderStatus: String,
	@ApiModelProperty("List client order id.")
	@JsonProperty("listClientOrderId")
	var listClientOrderId: String,
	@ApiModelProperty("Order timestamp.")
	@JsonProperty("transactionTime")
	var transactionTime: Long,
	@ApiModelProperty("Order symbol.")
	@JsonProperty("symbol")
	var symbol: String,
	@ApiModelProperty("The 2 orders.")
	@JsonProperty("orders")
	var orders: List<MiniOrderInfo>,
	@ApiModelProperty("is it an isolated trade?")
	@JsonProperty("isIsolated")
	var isIsolated: Boolean,
	@ApiModelProperty("Order reports.")
	@JsonProperty("orderReports")
	var orderReports: List<OCOOrderReport>
)