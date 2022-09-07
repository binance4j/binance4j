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
package com.binance4j.connectors.mining.client

import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.mining.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * [MiningClient] mapping.
 */
interface MiningMapping {
    /**
     * Acquiring algorithms.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/pub/algoList")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getAlgorithms(): Call<AlgorithmsResponse>

    /**
     * Acquiring coin name.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/pub/coinList")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getCoins(): Call<CoinsResponse>

    /**
     * Request for detail miner list.
     *
     * @param algo       Algorithm.
     * @param userName   Mining account.
     * @param workerName Miner’s name.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/worker/detail")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getMinersDetails(@Query("algo") algo: String, @Query("userName") userName: String, @Query("workerName") workerName: String): Call<MinerDetailsResponse>

    /**
     * Request for miner list.
     *
     * @param algo         Algorithm.
     * @param userName     Mining account.
     * @param pageIndex    Page number.
     * @param sort         Sort sequence.
     * @param sortColumn   Miner sort.
     * @param workerStatus Miner status.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/worker/list")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getMiners(
        @Query("algo") algo: String,
        @Query("userName") userName: String,
        @Query("workerStatus") workerStatus: String?,
        @Query("pageIndex") pageIndex: Int?,
        @Query("sort") sort: String?,
        @Query("sortColumn") sortColumn: String?
    ): Call<WorkersResponse>

    /**
     * Get earnings list.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account test.
     * @param coin      Coin name.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/payment/list")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getProfits(
        @Query("algo") algo: String,
        @Query("userName") userName: String,
        @Query("coin") coin: String?,
        @Query("startDate") startDate: Long?,
        @Query("endDate") endDate: Long?,
        @Query("pageIndex") pageIndex: Int?,
        @Query("pageSize") pageSize: Int?
    ): Call<ProfitResponse>

    /**
     * Get extra bonus list.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account test.
     * @param coin      Coin name.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/payment/other")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getOtherProfits(
        @Query("algo") algo: String, @Query("userName") userName: String, @Query("coin") coin: String?,
        @Query("startDate") startDate: Long?, @Query("endDate") endDate: Long?, @Query("pageIndex") pageIndex: Int?, @Query("pageSize") pageSize: Int?
    ): Call<OtherProfitsResponse>

    /**
     * Get mining account earning.
     *
     * @param algo      Transfer algorithm.
     * @param userName  Mining account.
     * @param startDate Start time in ms.
     * @param endDate   End time in ms.
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/payment/uid")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getAccountProfits(
        @Query("algo") algo: String,
        @Query("userName") userName: String,
        @Query("startDate") startDate: Long?,
        @Query("endDate") endDate: Long?,
        @Query("pageIndex") pageIndex: Int?,
        @Query("pageSize") pageSize: Int?
    ): Call<AccountProfitsResponse>

    /**
     * Get hash rate resale list.
     *
     * @param pageIndex Result page.
     * @param pageSize  Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/hash-transfer/config/details/list")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getHashrateResales(@Query("pageIndex") pageIndex: Int?, @Query("pageSize") pageSize: Int?): Call<HashrateResaleListResponse>

    /**
     * Get hash rate resale detail.
     *
     * @param configId    Config id.
     * @param userName    User name.
     * @param pageIndex   Result page.
     * @param pageSize    Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/hash-transfer/profit/details")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getHashrateResalesDetails(
        @Query("configId") configId: Int,
        @Query("userName") userName: String,
        @Query("pageIndex") pageIndex: Int?,
        @Query("pageSize") pageSize: Int?
    ): Call<HashrateResaleDetailResponse>

    /**
     * Hash rate resale request.
     *
     * @param userName   Mining Account test.
     * @param algo       Transfer algorithm.
     * @param endDate    Resale End Time in ms.
     * @param startDate  Resale Start Time in ms.
     * @param toPoolUser Mining Account.
     * @param hashRate   Resale hash rate h/s must be transferred (BTC is greater than 500000000000 ETH is greater than 500000).
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/mining/hash-transfer/config")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun resellHashrate(
        @Query("userName") userName: String,
        @Query("algo") algo: String,
        @Query("startDate") startDate: Long,
        @Query("endDate") endDate: Long,
        @Query("toPoolUser") toPoolUser: String,
        @Query("hashRate") hashRate: Long
    ): Call<HashrateResaleResponse>

    /**
     * Cancel hash rate resale configuration.
     *
     * @param configId Config id.
     * @param userName User name.
     *
     * @return The generated Retrofit call.
     */
    @POST("/sapi/v1/mining/hash-transfer/config/cancel")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun cancelHashrateResaleConfiguration(@Query("configId") configId: Int, @Query("userName") userName: String): Call<HashrateResaleCancellationResponse>

    /**
     * Get Statistic list.
     *
     * @param algo     Algorithm.
     * @param userName Mining account.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/statistics/user/status")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getStatistics(@Query("algo") algo: String, @Query("userName") userName: String): Call<StatisticsResponse>

    /**
     * Get Account list.
     *
     * @param algo     Algorithm.
     * @param userName Mining account.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/mining/statistics/user/list")
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
    fun getAccounts(@Query("algo") algo: String, @Query("userName") userName: String): Call<AccountListResponse>
}