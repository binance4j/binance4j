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

package com.binance4j.connectors.websocket.client

import com.binance4j.connectors.core.Headers.API_H
import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.websocket.dto.ListenKey
import retrofit2.Call
import retrofit2.http.*

/** [UserDataClient] mapping.  */
interface UserDataMapping {
	/** @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@POST("/api/v3/userDataStream")
	@JvmSuppressWildcards
	fun startUserDataStream(): Call<ListenKey>
	
	/**
	 * @param listenKey Authenticated account user listen key.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@PUT("/api/v3/userDataStream")
	@JvmSuppressWildcards
	fun keepAliveUserDataStream(@Query("listenKey") listenKey: String): Call<Void>
	
	/**
	 * @param listenKey Authenticated account user listen key.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/api/v3/userDataStream")
	@JvmSuppressWildcards
	fun closeUserDataStream(@Query("listenKey") listenKey: String): Call<Void>
	// MARGIN
	/**
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/userDataStream")
	@JvmSuppressWildcards
	fun startMarginUserDataStream(): Call<ListenKey>
	
	/**
	 * @param listenKey Authenticated account user listen key.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@PUT("/sapi/v1/userDataStream")
	@JvmSuppressWildcards
	fun keepAliveMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Void>
	
	/**
	 * @param listenKey Authenticated account user listen key.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/sapi/v1/userDataStream")
	@JvmSuppressWildcards
	fun closeMarginUserDataStream(@Query("listenKey") listenKey: String): Call<Void>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/userDataStream/isolated")
	@JvmSuppressWildcards
	fun startIsolatedUserDataStream(@QueryMap map: Map<String, Any>): Call<ListenKey>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@PUT("/sapi/v1/userDataStream/isolated")
	@JvmSuppressWildcards
	fun keepAliveIsolatedUserDataStream(@QueryMap map: Map<String, Any>): Call<Void>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit Call
	 */
	@Headers(API_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/sapi/v1/userDataStream/isolated")
	@JvmSuppressWildcards
	fun closeIsolatedUserDataStream(@QueryMap map: Map<String, Any>): Call<Void>
}