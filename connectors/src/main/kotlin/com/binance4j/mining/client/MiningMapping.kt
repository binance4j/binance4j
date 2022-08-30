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
package com.binance4j.mining.client

import com.binance4j.core.Headers.IP_H
import com.binance4j.core.Headers.SIGNED_H
import com.binance4j.mining.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.QueryMap

/**
 * [MiningClient] mapping.
 */
interface MiningMapping {
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/pub/algoList")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getAlgorithms(@QueryMap map: Map<String, Any>): Call<AlgorithmsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/pub/coinList")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getCoins(@QueryMap map: Map<String, Any>): Call<CoinsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/worker/detail")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getMinersDetails(@QueryMap map: Map<String, Any>): Call<MinerDetailsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/worker/list")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getMiners(@QueryMap map: Map<String, Any>): Call<WorkersResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/payment/list")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getProfits(@QueryMap map: Map<String, Any>): Call<ProfitResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/payment/other")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getOtherProfits(@QueryMap map: Map<String, Any>): Call<OtherProfitsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/payment/uid")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getAccountProfits(@QueryMap map: Map<String, Any>): Call<AccountProfitsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/hash-transfer/config/details/list")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getHashrateResales(@QueryMap map: Map<String, Any>): Call<HashrateResaleListResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/hash-transfer/profit/details")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getHashrateResalesDetails(@QueryMap map: Map<String, Any>): Call<HashrateResaleDetailResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/mining/hash-transfer/config")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun resellHashrate(@QueryMap map: Map<String, Any>): Call<HashrateResaleResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@POST("/sapi/v1/mining/hash-transfer/config/cancel")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun cancelHashrateResaleConfiguration(@QueryMap map: Map<String, Any>): Call<HashrateResaleCancellationResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/statistics/user/status")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getStatistics(@QueryMap map: Map<String, Any>): Call<StatisticsResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/mining/statistics/user/list")
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	fun getAccounts(@QueryMap map: Map<String, Any>): Call<AccountListResponse>
}