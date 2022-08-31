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
package com.binance4j.spot.param

import com.binance4j.core.dto.NewOrderResponseType
import com.binance4j.core.dto.OrderSide
import com.binance4j.core.dto.TimeInForce
import com.binance4j.core.param.Params

/**
 * A [SpotClient.newOCO] order.
 *
 * @property symbol                 Symbol the order is made on.
 * @property side                   Order side (BUY/SELL).
 * @property quantity               Order quantity.
 * @property price                  Order price.
 * @property stopPrice              Stop price.
 * @property stopLimitPrice         Stop limit price.
 * @property stopLimitTimeInForce   Valid values are GTC/FOK/IOC.
 * @property listClientOrderId      A unique Id for the entire orderList
 * @property limitClientOrderId     A unique Id for the limit order
 * @property limitIcebergQuantity   Used to make the LIMIT_MAKER leg an iceberg order.
 * @property stopClientOrderId      A unique id for the stop loss/stop loss limit leg
 * @property stopIcebergQuantity    Used with STOP_LOSS_LIMIT leg to make an iceberg order
 * @property limitStrategyId        Limit strategy id.
 * @property limitStrategyType      The value cannot be less than 1000000.
 * @property trailingDelta          Trailing delta.
 * @property stopStrategyId         Stop strategy id.
 * @property stopStrategyType       The value cannot be less than 1000000.
 */
data class NewOCOOrder @JvmOverloads constructor(
	var symbol: String,
	var side: OrderSide,
	var quantity: String,
	var price: String,
	var stopPrice: String,
	var stopLimitPrice: String?,
	var stopLimitTimeInForce: TimeInForce? = null,
	var newOrderRespType: NewOrderResponseType? = null,
	var listClientOrderId: String? = null,
	var limitClientOrderId: String? = null,
	var limitIcebergQuantity: String? = null,
	var stopClientOrderId: String? = null,
	var stopIcebergQuantity: String? = null,
	var limitStrategyId: Int? = null,
	var limitStrategyType: Int? = null,
	var trailingDelta: Long? = null,
	var stopStrategyId: Int? = null,
	var stopStrategyType: Int? = null
) : Params