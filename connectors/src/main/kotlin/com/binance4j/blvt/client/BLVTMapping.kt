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

package com.binance4j.blvt.client

import com.binance4j.blvt.dto.*
import com.binance4j.core.Binance4j.IP_H
import com.binance4j.core.Binance4j.SIGNED_H
import com.binance4j.core.Binance4j.WEIGHT_ONE_H
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/** [BLVTClient] mapping.  */
interface BLVTMapping {
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/tokenInfo")
	@Headers(SIGNED_H, WEIGHT_ONE_H)
	@JvmSuppressWildcards
	fun getTokenInfo(@QueryMap m: Map<String, Any>): Call<List<Token>>
	
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@POST("/sapi/v1/blvt/subscribe")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	@JvmSuppressWildcards
	fun subscribe(@QueryMap m: Map<String, Any>): Call<SubscriptionResponse>
	
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/subscribe/record")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	@JvmSuppressWildcards
	fun getSubscriptions(@QueryMap m: Map<String, Any>): Call<List<Subscription>>
	
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@POST("/sapi/v1/blvt/redeem")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	@JvmSuppressWildcards
	fun redeem(@QueryMap m: Map<String, Any>): Call<RedemptionResponse>
	
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/redeem/record")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	@JvmSuppressWildcards
	fun getRedemptions(@QueryMap m: Map<String, Any>): Call<List<Redemption>>
	
	/**
	 * @param m Parameters.
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/userLimit")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	@JvmSuppressWildcards
	fun getLimitInfo(@QueryMap m: Map<String, Any>): Call<List<LimitInfo>>
}