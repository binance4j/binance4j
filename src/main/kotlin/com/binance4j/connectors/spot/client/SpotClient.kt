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
package com.binance4j.connectors.spot.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.core.dto.NewOrderResponseType
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.spot.dto.NewOrder
import com.binance4j.connectors.spot.dto.OrderInfo

/**
 * API client for the SPOT endpoints
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade)
 */
object SpotClient : RestClient<SpotMapping>(SpotMapping::class.java) {
    /**
     * Defines if the client uses the test network.
     *
     * @param testnet network choice.
     */
    fun testnet(testnet: Boolean): SpotClient {
        createService(SpotMapping::class.java, testnet)
        return this
    }

    /**
     * Sends an order.
     *
     * @param order The order to send.
     */
    fun newOrder(order: NewOrder) = Request(service.newOrder(order.toMap()))

    /**
     * Sends an order.
     *
     * @param order The order to send.
     */
    fun newOrderTest(order: NewOrder) = Request(service.newOrderTest(order.toMap()))

    /**
     * Cancel an active order.
     *
     * @param symbol            Trade symbol.
     * @param orderId           Order id.
     * @param origClientOrderId Original client order id.
     * @param newClientOrderId  New client order id.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun cancelOrder(symbol: String, orderId: Long, origClientOrderId: String? = null, newClientOrderId: String? = null) =
        Request(service.cancelOrder(symbol, orderId, origClientOrderId, newClientOrderId))

    /**
     * Cancels all active orders on a symbol. This includes OCO orders.
     *
     * @param symbol Trade symbol.
     *
     * @return The request to execute.
     */

    fun cancelOpenOrders(symbol: String) = Request(service.cancelOpenOrders(symbol))

    /**
     * Check an order's status.
     *
     * Either orderId or origClientOrderId must be sent.
     * For some historical orders cumulative quote quantity will be &lt; 0, meaning the data is not available at this time.
     *

     * @param symbol            Trading pair.
     * @param origClientOrderId Client id.
     * @param orderId           Order id.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getOrderStatus(symbol: String, origClientOrderId: String? = null, orderId: Long? = null): Request<OrderInfo> =
        Request(service.getOrderStatus(symbol, origClientOrderId, orderId))

    /**
     * Get all open orders on a symbol.
     *
     * @param symbol Pair we want the open orders.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getOpenOrders(symbol: String? = null) = Request(service.getOpenOrders(symbol))

    /**
     * Get all orders on a symbol.
     *
     * @param symbol  Trading pair we want the orders.
     * @param orderId If orderId is set, it will get orders &gt;= that orderId. Otherwise, most recent orders are returned.
     * If startTime and/or endTime provided, orderId is not required.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAllOrders(symbol: String, orderId: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getAllOrders(symbol, orderId, startTime, endTime, limit))

    /**
     * Send in an OCO order.
     *
     * @param symbol                 Symbol the order is made on.
     * @param side                   Order side (BUY/SELL).
     * @param quantity               Order quantity.
     * @param price                  Order price.
     * @param stopPrice              Stop price.
     * @param stopLimitPrice         Stop limit price.
     * @param stopLimitTimeInForce   Valid values are GTC/FOK/IOC.
     * @param listClientOrderId      A unique Id for the entire orderList
     * @param limitClientOrderId     A unique Id for the limit order
     * @param limitIcebergQuantity   Used to make the LIMIT_MAKER leg an iceberg order.
     * @param stopClientOrderId      A unique id for the stop loss/stop loss limit leg
     * @param stopIcebergQuantity    Used with STOP_LOSS_LIMIT leg to make an iceberg order
     * @param limitStrategyId        Limit strategy id.
     * @param limitStrategyType      The value cannot be less than 1000000.
     * @param trailingDelta          Trailing delta.
     * @param stopStrategyId         Stop strategy id.
     * @param stopStrategyType       The value cannot be less than 1000000.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun newOCO(
        symbol: String,
        side: OrderSide,
        quantity: String,
        price: String,
        stopPrice: String,
        stopLimitPrice: String?,
        stopLimitTimeInForce: TimeInForce? = null,
        newOrderRespType: NewOrderResponseType? = null,
        listClientOrderId: String? = null,
        limitClientOrderId: String? = null,
        limitIcebergQuantity: String? = null,
        stopClientOrderId: String? = null,
        stopIcebergQuantity: String? = null,
        limitStrategyId: Int? = null,
        limitStrategyType: Int? = null,
        trailingDelta: Long? = null,
        stopStrategyId: Int? = null,
        stopStrategyType: Int? = null
    ) = Request(
        service.newOCO(
            symbol,
            side,
            quantity,
            price,
            stopPrice,
            stopLimitPrice,
            stopLimitTimeInForce,
            newOrderRespType,
            listClientOrderId,
            limitClientOrderId,
            limitIcebergQuantity,
            stopClientOrderId,
            stopIcebergQuantity,
            limitStrategyId,
            limitStrategyType,
            trailingDelta,
            stopStrategyId,
            stopStrategyType
        )
    )

    /**
     * Cancel an entire Order List. Canceling an individual leg will cancel the
     * entire OCO
     *
     * @param symbol            Symbol to cancel the order.
     * @param orderListId       Either `orderListId` or `listClientOrderId` must be provided.
     * @param listClientOrderId Either `orderListId` or `listClientOrderId` must be provided.
     * @param newClientOrderId  Used to uniquely identify this cancel. Automatically generated by default.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun cancelOCO(symbol: String, orderListId: Long? = null, listClientOrderId: String? = null, newClientOrderId: String? = null) =
        Request(service.cancelOCO(symbol, orderListId, listClientOrderId, newClientOrderId))

    /**
     * Retrieves a specific OCO based on provided optional parameters.
     *
     * @param orderListId       Either `orderListId` or `origClientOrderId` must be provided.
     * @param origClientOrderId Either `orderListId` or `origClientOrderId` must be provided.
     *
     * @return The request to execute.
     */
    fun getOCO(orderListId: Long? = null, origClientOrderId: String? = null) = Request(service.getOCO(orderListId, origClientOrderId))

    /**
     * Retrieves all OCO based on provided optional parameters.
     *
     * @param fromId    ID to search from.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAllOCO(fromId: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getAllOCO(fromId, startTime, endTime, limit))

    /**
     * Retrieves all open OCO.
     *
     * @return The request to execute.
     */
    fun getOpenOCO() = Request(service.getOpenOCO())

    /**
     * Get current account information.
     *
     * @return The request to execute.
     */
    fun getAccount() = Request(service.getAccount())

    /**
     * Get trades for a specific account and symbol. If fromId is set, it will get
     * id &gt;= fromId. Otherwise, most recent trades are returned.
     *
     *
     * @param symbol    Symbol of the trade.
     * @param orderId   Order id of the trade.
     * @param fromId    ID from which we search trades.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTrades(symbol: String, orderId: Long? = null, fromId: Long? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getTrades(symbol, orderId, fromId, startTime, endTime, limit))

    /**
     * Displays the user's current order count usage for all intervals with default
     * request
     *
     * @return The request to execute.
     */
    fun getOrderCount() = Request(service.getOrderCount())
}