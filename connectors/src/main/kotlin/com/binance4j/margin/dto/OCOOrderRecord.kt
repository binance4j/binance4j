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
	val orderListId: Long,
	@ApiModelProperty("Transaction timestamp in ms.")
	val transactionTime: Long,
	@ApiModelProperty("Related symbol.")
	val symbol: String,
	@ApiModelProperty("Contingency type.")
	val contingencyType: String,
	@ApiModelProperty("List status type.")
	val listStatusType: String,
	@ApiModelProperty("List order status.")
	val listOrderStatus: String,
	@ApiModelProperty("List client order id.")
	val listClientOrderId: String,
	@ApiModelProperty("Is the order isolated?")
	val isIsoslated: Boolean,
	@ApiModelProperty("The two orders.")
	var orders: List<OrderInfo>
)

