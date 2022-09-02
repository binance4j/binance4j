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

package com.binance4j.margin.param

import com.binance4j.core.dto.NewOrderResponseType
import com.binance4j.core.dto.OrderSide
import com.binance4j.core.dto.TimeInForce
import com.binance4j.core.param.Params

/**
 * [MarginClient.newOCO] params.
 *
 * @property symbol                 The order symbol.
 * @property side                   The order side.
 * @property quantity               The order quantity.
 * @property price                  The order price.
 * @property stopPrice              The stop price.
 * @property newOrderRespType       The order response type Default: RESULT.
 * @property listClientOrderId      A unique Id for the entire orderList.
 * @property limitClientOrderId     A unique Id for the limit order.
 * @property limitIcebergQty        Used to make the LIMIT_MAKER leg an iceberg order.
 * @property stopClientOrderId      A unique id for the stop loss/stop loss limit leg.
 * @property stopLimitPrice         If provided, stopLimitTimeInForce is required.
 * @property stopIcebergQty         Used with STOP_LOSS_LIMIT leg to make an iceberg order.
 * @property stopLimitTimeInForce   Valid values are GTC/FOK/IOC.
 * @property isIsolated             Is the order isolated?.
 * */
data class NewOCO @JvmOverloads constructor(
	var symbol: String,
	var side: OrderSide,
	var quantity: String,
	var price: String,
	var stopPrice: String,
	var newOrderRespType: NewOrderResponseType? = null,
	var listClientOrderId: String? = null,
	var limitClientOrderId: String? = null,
	var limitIcebergQty: String? = null,
	var stopClientOrderId: String? = null,
	var stopLimitPrice: String? = null,
	var stopIcebergQty: String? = null,
	var stopLimitTimeInForce: TimeInForce? = null,
	var isIsolated: Boolean? = null,
) : Params