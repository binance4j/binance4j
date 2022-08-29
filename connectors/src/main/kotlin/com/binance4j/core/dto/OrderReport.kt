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

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

/**
 * An order report.
 *
 * @property orderListId Order list id.
 * @property origClientOrderId Original client order id.
 * @property transactTime Order timestamp.
 * @property side Order side.
 * @property price Price.
 * @property origQty Original quantity.
 * @property executedQty Original quantity.
 * @property cumulativeQuoteQty Used to calculate the average price.
 * @property status Order status.
 * @property timeInForce Time in force to indicate how long will the order remain active.
 * @property type Type of order.
 * @property stopPrice Used with stop orders.
 * @property icebergQty Used with iceberg orders.
 * @property time Order timestamp.
 * @property updateTime Update timestamp.
 * @property origQuoteOrderQty Original quote order quantity.
 * @property isWorking Is working.
 * @property isIsolated is isolated margin.
 * @property symbol Order symbol.
 * @property orderId Order id.
 * @property clientOrderId Client order id.
 */
@ApiModel("An order report.")
data class OrderReport(
	@ApiModelProperty("The order list id.")
	val orderListId: Long,
	
	@ApiModelProperty("The original client order id.")
	val origClientOrderId: String,
	
	@ApiModelProperty("The order timestamp.")
	val transactTime: Long,
	
	@ApiModelProperty("The order side.")
	
	var side: OrderSide? = null,
	
	@ApiModelProperty("Price.")
	val price: String,
	
	@ApiModelProperty("Original quantity.")
	val origQty: String,
	
	@ApiModelProperty("Original quantity.")
	val executedQty: String,
	
	@ApiModelProperty("Used to calculate the average price.")
	val cumulativeQuoteQty: String,
	
	@ApiModelProperty("Order status.")
	val status: String,
	
	@ApiModelProperty("Time in force to indicate how long will the order remain active.")
	val timeInForce: String,
	
	@ApiModelProperty("Type of order.")
	val type: String,
	
	@ApiModelProperty("Used with stop orders.")
	val stopPrice: String,
	
	@ApiModelProperty("Used with iceberg orders.")
	val icebergQty: String,
	
	@ApiModelProperty("Order timestamp.")
	val time: Long,
	
	@ApiModelProperty("Update timestamp.")
	val updateTime: Long,
	
	@ApiModelProperty("Original quote order quantity.")
	val origQuoteOrderQty: String,
	
	@ApiModelProperty("Is working.")
	val isWorking: Boolean,
	
	@ApiModelProperty("is isolated margin.")
	val isIsolated: Boolean,
	
	@ApiModelProperty("The order symbol.")
	val symbol: String,
	
	@ApiModelProperty("Order id.")
	val orderId: Long,
	
	@ApiModelProperty("Client order id.")
	val clientOrderId: String
)
