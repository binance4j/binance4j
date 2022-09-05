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
import com.binance4j.connectors.core.dto.Trade
import com.binance4j.connectors.spot.dto.*
import retrofit2.Call
import retrofit2.http.*

/**
 * [SpotClient] mapping.
 */
interface SpotMapping {
	/**
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
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/api/v3/order")
	fun cancelOrder(@QueryMap map: Map<String, Any>): Call<CancelOrderResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/api/v3/openOrders")
	fun cancelOpenOrders(@QueryMap map: Map<String, Any>): Call<List<CancelOrderResponse>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 2")
	@GET("/api/v3/order")
	fun getOrderStatus(@QueryMap map: Map<String, Any>): Call<OrderInfo>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 40")
	@GET("/api/v3/openOrders")
	fun getOpenOrders(@QueryMap map: Map<String, Any>): Call<List<OrderInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/api/v3/allOrders")
	fun getAllOrders(@QueryMap map: Map<String, Any>): Call<List<OrderInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_UID_H, "X-WEIGHT: 2")
	@POST("/api/v3/order/oco")
	fun newOCO(@QueryMap map: Map<String, Any>): Call<OCOResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/api/v3/orderList")
	fun cancelOCO(@QueryMap map: Map<String, Any>): Call<OCOResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 2")
	@GET("/api/v3/orderList")
	fun queryOCO(@QueryMap map: Map<String, Any>): Call<OCOInfo>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/api/v3/allOrderList")
	fun getAllOCO(@QueryMap map: Map<String, Any>): Call<List<OCOInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 3")
	@GET("/api/v3/openOrderList")
	fun getOpenOCO(@QueryMap map: Map<String, Any>): Call<List<OCOInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/api/v3/account")
	fun getAccount(@QueryMap map: Map<String, Any>): Call<Account>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/api/v3/myTrades")
	fun getTrades(@QueryMap map: Map<String, Any>): Call<List<Trade>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 20")
	@GET("/api/v3/rateLimit/order")
	fun getOrderCount(@QueryMap map: Map<String, Any>): Call<List<OrderCount>>
}