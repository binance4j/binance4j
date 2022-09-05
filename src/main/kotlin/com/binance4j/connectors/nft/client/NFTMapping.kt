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

package com.binance4j.connectors.nft.client

import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.UID_H
import com.binance4j.connectors.nft.dto.AssetHistory
import com.binance4j.connectors.nft.dto.DepositHistory
import com.binance4j.connectors.nft.dto.TransactionHistory
import com.binance4j.connectors.nft.dto.WithdrawHistory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

/**
 * [NFTClient] mapping.
 */
interface NFTMapping {
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/nft/history/transactions")
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@JvmSuppressWildcards
	fun getTransactions(@QueryMap map: Map<String, Any>): Call<TransactionHistory>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/nft/history/deposit")
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@JvmSuppressWildcards
	fun getDeposits(@QueryMap map: Map<String, Any>): Call<DepositHistory>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/nft/history/withdraw")
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@JvmSuppressWildcards
	fun getWithdraws(@QueryMap map: Map<String, Any>): Call<WithdrawHistory>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/nft/user/getAsset")
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@JvmSuppressWildcards
	fun getAssets(@QueryMap map: Map<String, Any>): Call<AssetHistory>
}