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