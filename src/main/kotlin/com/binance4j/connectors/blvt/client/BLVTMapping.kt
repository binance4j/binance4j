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

package com.binance4j.connectors.blvt.client

import com.binance4j.connectors.blvt.dto.*
import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import retrofit2.Call
import retrofit2.http.*

/** [BLVTClient] mapping.  */
interface BLVTMapping {
	/**
	 * Get BLVT Info.
	 *
	 * @param tokenName Token name.
	 *
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/tokenInfo")
	@Headers(SIGNED_H, WEIGHT_ONE_H)
	fun getTokenInfo(@Query("tokenName") tokenName: String? = null): Call<List<Token>>

	/**
	 * Get subscription record.
	 *
	 * @param tokenName  Token name.
	 * @param id         Subscription id.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param limit      Results limit.
	 *
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/subscribe/record")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	fun getSubscriptions(@Query("tokenName") tokenName: String? = null, @Query("id") id: Long? = null, @Query("startTime") startTime: Long? = null, @Query("endTime") endTime: Long? = null, @Query("limit") limit: Int? = null): Call<List<Subscription>>


	/**
	 * Get redemption record.
	 *
	 * @param tokenName  Token name.
	 * @param id         Subscription id.
	 * @param startTime  Start time in ms.
	 * @param endTime    End time in ms.
	 * @param limit      Results limit.
	 *
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/redeem/record")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	fun getRedemptions(@Query("tokenName") tokenName: String? = null, @Query("id") id: Long? = null, @Query("startTime") startTime: Long? = null, @Query("endTime") endTime: Long? = null, @Query("limit") limit: Int? = null): Call<List<Redemption>>

	/**
	 * Get user limit info.
	 *
	 * @param tokenName Token name.
	 *
	 * @return An API call.
	 */
	@GET("/sapi/v1/blvt/userLimit")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	fun getLimitInfo(@Query("tokenName") tokenName: String? = null): Call<List<LimitInfo>>

	/**
	 * Subscribe BLVT.
	 *
	 * @param tokenName Token name.
	 * @param cost      Cost to subscribe to.
	 *
	 * @return An API call.
	 */
	@POST("/sapi/v1/blvt/subscribe")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	fun subscribe(@Query("tokenName") tokenName: String, @Query("cost") cost: String): Call<SubscriptionResponse>

	/**
	 * Redeem BLVT.
	 *
	 * @param tokenName Token name.
	 * @param amount    Amount to redeem.
	 *
	 * @return An API call.
	 */
	@POST("/sapi/v1/blvt/redeem")
	@Headers(SIGNED_H, WEIGHT_ONE_H, IP_H)
	fun redeem(@Query("tokenName") tokenName: String, @Query("amount") amount: String): Call<RedemptionResponse>
}