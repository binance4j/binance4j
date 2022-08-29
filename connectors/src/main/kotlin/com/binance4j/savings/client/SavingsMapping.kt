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
package com.binance4j.savings.client

import com.binance4j.core.Binance4j.IP_H
import com.binance4j.core.Binance4j.SIGNED_H
import com.binance4j.core.Binance4j.WEIGHT_ONE_H
import com.binance4j.savings.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * [SavingsClient] mapping.
 */
interface SavingsMapping {
	// FLEXIBLE //
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/daily/product/list")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getFlexibleProducts(@QueryMap map: Map<String, Any>): Call<List<FlexibleProduct>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/daily/userLeftQuota")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getLeftDailyFlexiblePurchaseQuota(@QueryMap map: Map<String, Any>): Call<PurchaseQuota>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/lending/daily/purchase")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun purchaseFlexible(@QueryMap map: Map<String, Any>): Call<PurchaseResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/daily/userRedemptionQuota")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getLeftDailyRedemptionQuota(@QueryMap map: Map<String, Any>): Call<RedemptionQuota>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/lending/daily/redeem")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun redeemFlexible(@QueryMap map: Map<String, Any>): Call<Void>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/daily/token/position")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getFlexibleProductPosition(@QueryMap map: Map<String, Any>): Call<List<FlexibleProductPosition>>
	// FIXED //
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/project/list")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getFixedProjects(@QueryMap map: Map<String, Any>): Call<List<FixedProject>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/lending/customizedFixed/purchase")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun purchaseFixed(@QueryMap map: Map<String, Any>): Call<PurchaseResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/project/position/list")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getFixedProjectPosition(@QueryMap map: Map<String, Any>): Call<List<FixedProjectPosition>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/union/account")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getAccount(@QueryMap map: Map<String, Any>): Call<LendingAccount>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/union/purchaseRecord")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getPurchases(@QueryMap map: Map<String, Any>): Call<List<Purchase>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/union/redemptionRecord")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getRedemptions(@QueryMap map: Map<String, Any>): Call<List<Redemption>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/lending/union/interestHistory")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun getInterests(@QueryMap map: Map<String, Any>): Call<List<Interest>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/lending/positionChanged")
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	fun fixedToDailyPosition(@QueryMap map: Map<String, Any>): Call<PositionChangedResponse>
}