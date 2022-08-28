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
import com.binance4j.core.client.RestMapping
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/** [BLVTClient] mapping.  */
interface BLVTMapping : RestMapping {
    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "tokenInfo")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H)
    @JvmSuppressWildcards
    fun getTokenInfo(@QueryMap map: Map<String, Any>): Call<List<Token>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @POST(BASE + "subscribe")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H, RestMapping.IP_H)
    @JvmSuppressWildcards
    fun subscribe(@QueryMap map: Map<String, Any>): Call<SubscriptionResponse>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "subscribe/record")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H, RestMapping.IP_H)
    @JvmSuppressWildcards
    fun getSubscriptions(@QueryMap map: Map<String, Any>): Call<List<Subscription>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @POST(BASE + "redeem")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H, RestMapping.IP_H)
    @JvmSuppressWildcards
    fun redeem(@QueryMap map: Map<String, Any>): Call<RedemptionResponse>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "redeem/record")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H, RestMapping.IP_H)
    @JvmSuppressWildcards
    fun getRedemptions(@QueryMap map: Map<String, Any>): Call<List<Redemption>>

    /**
     * @param map Query map.
     * @return The generated Retrofit call.
     */
    @GET(BASE + "userLimit")
    @Headers(RestMapping.SIGNED_H, RestMapping.WEIGHT_ONE_H, RestMapping.IP_H)
    @JvmSuppressWildcards
    fun getLimitInfo(@QueryMap map: Map<String, Any>): Call<List<LimitInfo>>

    companion object {
        /** The base uri.  */
        const val BASE = "/sapi/v1/blvt/"
    }
}
