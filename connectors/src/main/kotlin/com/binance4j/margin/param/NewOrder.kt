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
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN ? = null, EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.margin.param

import com.binance4j.core.dto.NewOrderResponseType
import com.binance4j.core.dto.OrderSide
import com.binance4j.core.dto.OrderType
import com.binance4j.core.dto.TimeInForce
import com.binance4j.core.param.Params
import com.binance4j.margin.dto.SideEffectType

/**
 * A SPOT order.
 *
 * @property symbol             Asset pair to trade on.
 * @property side               order side.
 * @property type               NewOrder type.
 * @property isIsolated         For isolated margin or not.
 * @property timeInForce        Time in force.
 * @property price              Trade price.
 * @property quantity           Base asset quantity.
 * @property quoteOrderQty      Quote asset quantity.
 * @property icebergQty         Iceberg quantity.
 * @property stopPrice          Stop price.
 * @property newClientOrderId   A unique id among open orders. Automatically generated if not sent.
 * @property sideEffectType     Side effect type.
 * @property newOrderRespType   Desired response type.
 */
data class NewOrder @JvmOverloads constructor(
	var symbol: String,
	var side: OrderSide,
	var type: OrderType,
	var isIsolated: Boolean? = null,
	var timeInForce: TimeInForce? = null,
	var price: String? = null,
	var quantity: String? = null,
	var quoteOrderQty: String? = null,
	var icebergQty: String? = null,
	var stopPrice: String? = null,
	var newClientOrderId: String? = null,
	var sideEffectType: SideEffectType? = null,
	var newOrderRespType: NewOrderResponseType? = null
) : Params {
	companion object {
		
		/**
		 * @param symbol             Symbol.
		 * @param side               Side.
		 * @param quantity           NewOrder quantity.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Market order.
		 */
		fun market(
			symbol: String,
			side: OrderSide,
			quantity: String,
			isIsolated: Boolean? = null,
			sideEffectType: SideEffectType? = null
		) =
			NewOrder(
				symbol,
				side,
				OrderType.MARKET,
				quantity = quantity,
				isIsolated = isIsolated,
				sideEffectType = sideEffectType
			)
		
		/**
		 * @param symbol             Symbol.
		 * @param side               Side.
		 * @param quoteOrderQty      Quote asset quantity.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Market order by the quote asset.
		 */
		fun marketQuote(
			symbol: String,
			side: OrderSide,
			quoteOrderQty: String,
			isIsolated: Boolean? = null,
			sideEffectType: SideEffectType? = null
		) =
			NewOrder(
				symbol,
				side,
				OrderType.MARKET,
				quantity = quoteOrderQty,
				isIsolated = isIsolated,
				sideEffectType = sideEffectType
			)
		
		/**
		 * @param symbol             Symbol.
		 * @param side               Side.
		 * @param timeInForce        The timeInForce to set
		 * @param price              NewOrder price.
		 * @param quantity           NewOrder quantity.
		 * @param icebergQty         IcebergQty to set
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Limit order.
		 */
		@JvmOverloads
		fun limit(
			symbol: String,
			side: OrderSide,
			quantity: String,
			price: String,
			icebergQty: String? = null,
			timeInForce: TimeInForce? = null,
			isIsolated: Boolean? = null,
			sideEffectType: SideEffectType? = null
		) = NewOrder(
			symbol,
			side,
			OrderType.LIMIT,
			quantity = quantity,
			price = price,
			icebergQty = icebergQty,
			timeInForce = timeInForce,
			isIsolated = isIsolated,
			sideEffectType = sideEffectType
		)
		
		/**
		 * @param symbol             Asset pair to trade on.
		 * @param side               order side.
		 * @param price              Trade price.
		 * @param quantity           Base asset quantity.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A limit Maker order.
		 */
		fun limitMaker(
			symbol: String,
			side: OrderSide,
			quantity: String,
			price: String,
			isIsolated: Boolean? = null,
			sideEffectType: SideEffectType? = null
		) =
			NewOrder(
				symbol,
				side,
				OrderType.LIMIT_MAKER,
				quantity = quantity,
				price = price,
				isIsolated = isIsolated,
				sideEffectType = sideEffectType
			)
		
		/**
		 * @param symbol             Asset pair to trade on.
		 * @param side               order side.
		 * @param quantity           Base asset quantity.
		 * @param stopPrice          Stop price.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Stop Loss order.
		 */
		@JvmOverloads
		fun stopLoss(
			symbol: String, side: OrderSide, quantity: String,
			stopPrice: String? = null, isIsolated: Boolean? = null, sideEffectType: SideEffectType? = null
		) = NewOrder(
			symbol = symbol, side = side, OrderType.STOP_LOSS,
			quantity = quantity, stopPrice = stopPrice,
			isIsolated = isIsolated, sideEffectType = sideEffectType
		)
		
		/**
		 *
		 * @param symbol             Asset pair to trade on.
		 * @param side               order side.
		 * @param timeInForce        Time in force.
		 * @param price              Trade price.
		 * @param quantity           Base asset quantity.
		 * @param icebergQty         Iceberg quantity.
		 * @param stopPrice          Stop price.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Stop Loss Limit order.
		 */
		@JvmOverloads
		fun stopLossLimit(
			symbol: String, side: OrderSide, quantity: String,
			price: String, stopPrice: String? = null, timeInForce: TimeInForce? = null,
			icebergQty: String? = null, isIsolated: Boolean? = null, sideEffectType: SideEffectType? = null
		) = NewOrder(
			symbol, side, OrderType.STOP_LOSS_LIMIT,
			quantity = quantity, price = price, stopPrice = stopPrice,
			timeInForce = timeInForce, icebergQty = icebergQty,
			isIsolated = isIsolated, sideEffectType = sideEffectType
		)
		
		/**
		 * @param symbol             Asset pair to trade on.
		 * @param side               order side.
		 * @param quantity           Base asset quantity.
		 * @param stopPrice          Stop price.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Take Profit order.
		 */
		@JvmOverloads
		fun takeProfit(
			symbol: String, side: OrderSide, quantity: String,
			stopPrice: String? = null, isIsolated: Boolean? = null, sideEffectType: SideEffectType? = null
		) = NewOrder(
			symbol, side, OrderType.TAKE_PROFIT,
			quantity = quantity, stopPrice = stopPrice,
			isIsolated = isIsolated, sideEffectType = sideEffectType
		)
		
		/**
		 * @param symbol             Asset pair to trade on.
		 * @param side               order side.
		 * @param timeInForce        Time in force.
		 * @param price              Trade price.
		 * @param quantity           Base asset quantity.
		 * @param icebergQty         Iceberg quantity.
		 * @param stopPrice          Stop price.
		 * @param isIsolated         For isolated margin or not.
		 * @param sideEffectType     Side effect type.
		 * @return A Take Profit Limit order.
		 */
		@JvmOverloads
		fun takeProfitLimit(
			symbol: String, side: OrderSide, quantity: String,
			price: String, timeInForce: TimeInForce, icebergQty: String? = null,
			stopPrice: String? = null, isIsolated: Boolean? = null, sideEffectType: SideEffectType? = null
		) = NewOrder(
			symbol, side, OrderType.TAKE_PROFIT_LIMIT, quantity = quantity,
			price = price, timeInForce = timeInForce, icebergQty = icebergQty,
			stopPrice = stopPrice, isIsolated = isIsolated, sideEffectType = sideEffectType
		)
	}
}