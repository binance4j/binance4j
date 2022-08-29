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
package com.binance4j.staking.client

import com.binance4j.core.client.RestMapping
import com.binance4j.core.client.RestMapping.Companion.IP_H
import com.binance4j.core.client.RestMapping.Companion.SIGNED_H
import com.binance4j.core.client.RestMapping.Companion.WEIGHT_ONE_H
import com.binance4j.staking.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * [StakingClient] mapping.
 */
interface StakingMapping : RestMapping {
    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/productList")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun getProductList(@QueryMap map: Map<String, Any>): Call<List<Product>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/staking/purchase")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun purchase(@QueryMap map: Map<String, Any>): Call<PurchaseResponse>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/staking/redeem")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun redeem(@QueryMap map: Map<String, Any>): Call<RedeemResponse>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/position")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun getPosition(@QueryMap map: Map<String, Any>): Call<List<ProductPosition>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/stakingRecord")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun getHistory(@QueryMap map: Map<String, Any>): Call<List<StakingRecord>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/setAutoStaking")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun setAutoStaking(@QueryMap map: Map<String, Any>): Call<AutoStakingResponse>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/personalLeftQuota")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun getLeftQuota(@QueryMap map: Map<String, Any>): Call<LeftQuota>
}