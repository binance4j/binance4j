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

import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.IP_UID_H
import com.binance4j.connectors.core.Headers.IS_ORDER_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.core.dto.NewOrderResponseType
import com.binance4j.connectors.core.dto.OrderSide
import com.binance4j.connectors.core.dto.TimeInForce
import com.binance4j.connectors.core.dto.Trade
import com.binance4j.connectors.spot.dto.*
import retrofit2.Call
import retrofit2.http.*

/**
 * [SpotClient] mapping.
 */
interface SpotMapping {
    /**
     * Sends an order.
     *
     * @param map Query map.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_UID_H, WEIGHT_ONE_H, IS_ORDER_H)
    @POST("/api/v3/order")
    fun newOrder(@QueryMap map: Map<String, Any>): Call<NewOrderResponse>

    /**
     * @param map Query map.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_UID_H, WEIGHT_ONE_H)
    @POST("/api/v3/order/test")
    fun newOrderTest(@QueryMap map: Map<String, Any>): Call<Void>

    /**
     * Cancel an active order.
     *
     * @param symbol            Trade symbol.
     * @param orderId           Order id.
     * @param origClientOrderId Original client order id.
     * @param newClientOrderId  New client order id.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @DELETE("/api/v3/order")
    fun cancelOrder(symbol: String, orderId: Long, origClientOrderId: String?, newClientOrderId: String?): Call<CancelOrderResponse>

    /**
     * Cancels all active orders on a symbol. This includes OCO orders.
     *
     * @param symbol Trade symbol.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @DELETE("/api/v3/openOrders")
    fun cancelOpenOrders(symbol: String): Call<List<CancelOrderResponse>>

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
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 2")
    @GET("/api/v3/order")
    fun getOrderStatus(symbol: String, origClientOrderId: String?, orderId: Long?): Call<OrderInfo>

    /**
     * Get all open orders on a symbol.
     *
     * @param symbol Pair we want the open orders.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 40")
    @GET("/api/v3/openOrders")
    fun getOpenOrders(symbol: String?): Call<List<OrderInfo>>

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
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/api/v3/allOrders")
    fun getAllOrders(symbol: String, orderId: Long?, startTime: Long?, endTime: Long?, limit: Int?): Call<List<OrderInfo>>

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
     **
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_UID_H, "X-WEIGHT: 2")
    @POST("/api/v3/order/oco")
    fun newOCO(
        symbol: String,
        side: OrderSide,
        quantity: String,
        price: String,
        stopPrice: String,
        stopLimitPrice: String?,
        stopLimitTimeInForce: TimeInForce?,
        newOrderRespType: NewOrderResponseType?,
        listClientOrderId: String?,
        limitClientOrderId: String?,
        limitIcebergQuantity: String?,
        stopClientOrderId: String?,
        stopIcebergQuantity: String?,
        limitStrategyId: Int?,
        limitStrategyType: Int?,
        trailingDelta: Long?,
        stopStrategyId: Int?,
        stopStrategyType: Int?
    ): Call<OCOResponse>

    /**
     * Cancel an entire Order List. Canceling an individual leg will cancel the
     * entire OCO
     *
     * @param symbol            Symbol to cancel the order.
     * @param orderListId       Either `orderListId` or `listClientOrderId` must be provided.
     * @param listClientOrderId Either `orderListId` or `listClientOrderId` must be provided.
     * @param newClientOrderId  Used to uniquely identify this cancel. Automatically generated by default.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @DELETE("/api/v3/orderList")
    fun cancelOCO(symbol: String, orderListId: Long?, listClientOrderId: String?, newClientOrderId: String?): Call<OCOResponse>

    /**
     * Retrieves a specific OCO based on provided optional parameters.
     *
     * @param orderListId       Either `orderListId` or `origClientOrderId` must be provided.
     * @param origClientOrderId Either `orderListId` or `origClientOrderId` must be provided.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 2")
    @GET("/api/v3/orderList")
    fun getOCO(orderListId: Long?, origClientOrderId: String?): Call<OCOInfo>

    /**
     * Retrieves all OCO based on provided optional parameters.
     *
     * @param fromId    ID to search from.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/api/v3/allOrderList")
    fun getAllOCO(fromId: Long?, startTime: Long?, endTime: Long?, limit: Int?): Call<List<OCOInfo>>

    /**
     * Retrieves all open OCO.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 3")
    @GET("/api/v3/openOrderList")
    fun getOpenOCO(): Call<List<OCOInfo>>

    /**
     * Get current account information.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/api/v3/account")
    fun getAccount(): Call<Account>

    /**
     * Get trades for a specific account and symbol. If fromId is set, it will get
     * id &gt;= fromId. Otherwise, most recent trades are returned.
     *
     *
     * @param symbol  Symbol of the trade.
     * @param orderId Order id of the trade.
     * @param fromId  ID from which we search trades.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/api/v3/myTrades")
    fun getTrades(symbol: String, orderId: Long?, fromId: Long?, startTime: Long?, endTime: Long?, limit: Int?): Call<List<Trade>>

    /**
     * Displays the user's current order count usage for all intervals with default
     * request
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 20")
    @GET("/api/v3/rateLimit/order")
    fun getOrderCount(): Call<List<OrderCount>>
}