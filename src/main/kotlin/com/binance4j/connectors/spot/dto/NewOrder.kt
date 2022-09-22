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

package com.binance4j.connectors.spot.dto

import com.binance4j.connectors.core.dto.NewOrderResponseType
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.OrderType
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.core.param.Params

/**
 * A SPOT order.
 *
 * @property symbol             Asset pair to trade on.
 * @property side               order side.
 * @property type               NewOrder type.
 * @property timeInForce        Time in force.
 * @property price              Trade price.
 * @property quantity           Base asset quantity.
 * @property quoteOrderQty      Quote asset quantity.
 * @property icebergQty         Iceberg quantity.
 * @property stopPrice          Stop price.
 * @property trailingDelta      Trailing delta.
 * @property newClientOrderId   A unique id among open orders. Automatically generated if not sent.
 * @property strategyId         Strategy id.
 * @property strategyType       Strategy type. The value cannot be less than 1000000.
 * @property newOrderRespType   Desired response type.
 */
data class NewOrder @JvmOverloads constructor(
    var symbol: String,
    var side: OrderSide,
    var type: OrderType,
    var timeInForce: TimeInForce? = null,
    var price: String? = null,
    var quantity: String? = null,
    var quoteOrderQty: String? = null,
    var icebergQty: String? = null,
    var stopPrice: String? = null,
    var trailingDelta: Long? = null,
    var newClientOrderId: String? = null,
    var strategyId: Int? = null,
    var strategyType: Int? = null,
    var newOrderRespType: NewOrderResponseType? = null
) : Params {
    companion object {

        /**
         * @param symbol             Symbol.
         * @param side               Side.
         * @param quantity           NewOrder quantity.
         *
         * @return A Market order.
         */
        fun market(symbol: String, side: OrderSide, quantity: String) =
            NewOrder(symbol, side, OrderType.MARKET, quantity = quantity)

        /**
         * @param symbol             Symbol.
         * @param side               Side.
         * @param quoteOrderQty      Quote asset quantity.
         *
         * @return A Market order by the quote asset.
         */
        fun marketQuote(symbol: String, side: OrderSide, quoteOrderQty: String) =
            NewOrder(symbol, side, OrderType.MARKET, quantity = quoteOrderQty)

        /**
         * @param symbol             Symbol.
         * @param side               Side.
         * @param timeInForce        The timeInForce to set
         * @param price              NewOrder price.
         * @param quantity           NewOrder quantity.
         * @param icebergQty         IcebergQty to set
         *
         * @return A Limit order.
         */
        @JvmOverloads
        fun limit(
            symbol: String, side: OrderSide, quantity: String,
            price: String, icebergQty: String? = null, timeInForce: TimeInForce? = null
        ) = NewOrder(
            symbol, side, OrderType.LIMIT, quantity = quantity,
            price = price, icebergQty = icebergQty, timeInForce = timeInForce
        )

        /**
         * @param symbol             Asset pair to trade on.
         * @param side               order side.
         * @param price              Trade price.
         * @param quantity           Base asset quantity.
         *
         * @return A limit Maker order.
         */
        fun limitMaker(symbol: String, side: OrderSide, quantity: String, price: String) =
            NewOrder(symbol, side, OrderType.LIMIT_MAKER, quantity = quantity, price = price)

        /**
         * @param symbol             Asset pair to trade on.
         * @param side               order side.
         * @param quantity           Base asset quantity.
         * @param stopPrice          Stop price.
         * @param trailingDelta      Trailing delta.
         *
         * @return A Stop Loss order.
         */
        @JvmOverloads
        fun stopLoss(
            symbol: String, side: OrderSide, quantity: String,
            stopPrice: String? = null, trailingDelta: Long? = null
        ) = NewOrder(
            symbol = symbol, side = side, OrderType.STOP_LOSS,
            quantity = quantity, stopPrice = stopPrice, trailingDelta = trailingDelta
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
         * @param trailingDelta      Trailing delta.
         *
         * @return A Stop Loss Limit order.
         */
        @JvmOverloads
        fun stopLossLimit(
            symbol: String, side: OrderSide, quantity: String,
            price: String, stopPrice: String? = null, timeInForce: TimeInForce? = null,
            icebergQty: String? = null, trailingDelta: Long? = null
        ) = NewOrder(
            symbol, side, OrderType.STOP_LOSS_LIMIT,
            quantity = quantity, price = price, stopPrice = stopPrice,
            timeInForce = timeInForce, icebergQty = icebergQty, trailingDelta = trailingDelta,
        )

        /**
         * @param symbol             Asset pair to trade on.
         * @param side               order side.
         * @param quantity           Base asset quantity.
         * @param stopPrice          Stop price.
         * @param trailingDelta      Trailing delta.
         *
         * @return A Take Profit order.
         */
        @JvmOverloads
        fun takeProfit(
            symbol: String, side: OrderSide, quantity: String,
            stopPrice: String? = null, trailingDelta: Long? = null
        ) = NewOrder(
            symbol, side, OrderType.TAKE_PROFIT,
            quantity = quantity, stopPrice = stopPrice, trailingDelta = trailingDelta
        )

        /**
         * @param symbol             Asset pair to trade on.
         * @param side               order side.
         * @param timeInForce        Time in force.
         * @param price              Trade price.
         * @param quantity           Base asset quantity.
         * @param icebergQty         Iceberg quantity.
         * @param stopPrice          Stop price.
         * @param trailingDelta      Trailing delta.
         *
         * @return A Take Profit Limit order.
         */
        @JvmOverloads
        fun takeProfitLimit(
            symbol: String,
            side: OrderSide, quantity: String,
            price: String, timeInForce: TimeInForce, icebergQty: String? = null,
            stopPrice: String? = null, trailingDelta: Long? = null
        ) = NewOrder(
            symbol, side, OrderType.TAKE_PROFIT_LIMIT, quantity = quantity,
            price = price, timeInForce = timeInForce, icebergQty = icebergQty,
            stopPrice = stopPrice, trailingDelta = trailingDelta
        )
    }
}