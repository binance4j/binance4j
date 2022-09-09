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
package com.binance4j.connectors.staking.client

import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.staking.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * [StakingClient] mapping.
 */
interface StakingMapping {
    /**
     * Get available Staking product list.
     *
     * @param product Product type.
     * @param asset   Product name.
     * @param current  Results page.
     * @param size Number of rows.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/productList")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getProducts(
        @Query("product") product: String,
        @Query("asset") asset: String?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<Product>>

    /**
     * Purchase Staking product.
     *
     * @param product   Product type.
     * @param productId Product id.
     * @param amount    Amount to purchase.
     * @param renewable Renew purchase? Active if product is `STAKING` or `L_DEFI`.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/staking/purchase")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun purchase(
        @Query("product") product: String,
        @Query("productId") productId: String,
        @Query("amount") amount: String,
        @Query("renewable") renewable: Boolean?
    ): Call<PurchaseResponse>

    /**
     * Redeem Staking product.
     *
     * @param product    Product type.
     * @param productId  Product id.
     * @param positionId Position id. Mandatory if product is `STAKING` or `L_DEFI`.
     * @param amount     Amount to purchase. Mandatory if product is `F_DEFI`.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/staking/redeem")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun redeem(
        @Query("product") product: String,
        @Query("productId") productId: String,
        @Query("positionId") positionId: String?,
        @Query("amount") amount: String?
    ): Call<RedeemResponse>

    /**
     * Get Staking product position.
     *
     * @param product   Product type.
     * @param productId Product id.
     * @param asset     Product name.
     * @param current   Results page.
     * @param size      Number of rows.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/position")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getPosition(
        @Query("product") product: String,
        @Query("productId") productId: String?,
        @Query("asset") asset: String?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<ProductPosition>>

    /**
     * Get staking history.
     *
     * @property product    Product type.
     * @property txnType    Transaction type.
     * @property asset      Product name.
     * @property startTime     Start time in ms.
     * @property endTime       End time in ms.
     * @property current       Result page.
     * @property size          Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/stakingRecord")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getHistory(
        @Query("product") product: String,
        @Query("txnType") txnType: String,
        @Query("asset") asset: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<StakingRecord>>

    /**
     * Set auto staking on Locked Staking or Locked DeFi Staking.
     *
     * @param product    Product type.
     * @param positionId Position id.
     * @param renewable  Renew purchase?
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/setAutoStaking")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun setAutoStaking(
        @Query("product") product: ProductType,
        @Query("positionId") positionId: String,
        @Query("renewable") renewable: Boolean
    ): Call<AutoStakingResponse>

    /**
     * Get personal left quota of Staking product.
     *
     * @param product   Product type.
     * @param productId Product id.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/staking/personalLeftQuota")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getLeftQuota(@Query("product") product: String, @Query("productId") productId: String): Call<LeftQuota>
}