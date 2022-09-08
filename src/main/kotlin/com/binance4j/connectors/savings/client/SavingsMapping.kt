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
package com.binance4j.connectors.savings.client

import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.savings.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * [SavingsClient] mapping.
 */
interface SavingsMapping {
    /**
     * Get flexible product list.
     *
     * @param status    Product status.
     * @param featured  Featured.
     * @param current   Current page.
     * @param size      Page size.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/daily/product/list")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getFlexibleProducts(
        @Query("status") status: String?,
        @Query("featured") featured: Featured?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<FlexibleProduct>>

    /**
     * Get left daily purchase quota of flexible product.
     *
     * @param productId Product id.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/daily/userLeftQuota")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getLeftDailyFlexiblePurchaseQuota(@Query("productId") productId: String): Call<PurchaseQuota>

    /**
     * Purchase Flexible Product.
     *
     * @param productId Product id.
     * @param amount    Amount.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/lending/daily/purchase")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun purchaseFlexible(@Query("productId") productId: String, @Query("amount") amount: String): Call<PurchaseResponse>

    /**
     * Get Left Daily Redemption Quota of Flexible Product.
     *
     * @param productId Product id.
     * @param type      Product type.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/daily/userRedemptionQuota")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getLeftDailyRedemptionQuota(@Query("productId") productId: String, @Query("type") type: String): Call<RedemptionQuota>

    /**
     * Redeem Flexible Product.
     *
     * @param productId Product id.
     * @param amount    Amount.
     * @param type      Product type.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/lending/daily/redeem")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun redeemFlexible(@Query("productId") productId: String, @Query("amount") amount: String, @Query("type") type: String): Call<Void>

    /**
     * Get flexible product position.
     *
     * @param asset Asset.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/daily/token/position")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getFlexibleProductPosition(@Query("asset") asset: String?): Call<List<FlexibleProductPosition>>

    /**
     * Get fixed and activity project list.
     *
     * @param type   Project type.
     * @param status Project status. default: `START_TIME`.
     * @param sortBy Sorting.
     * @param asset  Asset.
     * @param page  Results page.
     * @param limit Number of rows.
     * @param isSortAsc Ascending sorting.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/project/list")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getFixedProjects(
        @Query("type") type: String,
        @Query("status") status: String,
        @Query("sortBy") sortBy: String,
        @Query("asset") asset: String?,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?,
        @Query("isSortAsc") isSortAsc: Boolean?
    ): Call<List<FixedProject>>

    /**
     * Purchase fixed project.
     *
     * @param productId Product id.
     * @param lot       Amount.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/lending/customizedFixed/purchase")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun purchaseFixed(@Query("productId") productId: String, @Query("lot") lot: Long): Call<PurchaseResponse>

    /**
     * Get fixed/activity project position.
     *
     * @param asset     Asset.
     * @param projectId Project id.
     * @param status    Status.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/project/position/list")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getFixedProjectPosition(
        @Query("asset") asset: String?,
        @Query("projectId") projectId: String?,
        @Query("status") status: String?
    ): Call<List<FixedProjectPosition>>

    /**
     * Get lending account.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/union/account")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getAccount(): Call<LendingAccount>

    /**
     * Get purchase record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/union/purchaseRecord")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getPurchases(
        @Query("lendingType") lendingType: String,
        @Query("asset") asset: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<Purchase>>

    /**
     * Get redemption record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/union/redemptionRecord")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getRedemptions(
        @Query("lendingType") lendingType: String,
        @Query("asset") asset: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Int?,
        @Query("size") size: Int?
    ): Call<List<Redemption>>

    /**
     * Get interest record.
     *
     * @param lendingType Lending type.
     * @param asset       Asset name.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param current      Result page.
     * @param size     Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/lending/union/interestHistory")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun getInterests(
        @Query("lendingType") lendingType: String,
        @Query("asset") asset: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("current") current: Int?,
        @Query("size") size:
        Int?
    ): Call<List<Interest>>

    /**
     * Change fixed/activity position to daily position.
     *
     * @param projectId  Project id.
     * @param lot        Lot size.
     * @param positionId Position id for fixed position.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/lending/positionChanged")
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    fun fixedToDailyPosition(
        @Query("projectId") projectId: String,
        @Query("lot") lot: Long,
        @Query("positionId") positionId: Long?
    ): Call<PositionChangedResponse>
}