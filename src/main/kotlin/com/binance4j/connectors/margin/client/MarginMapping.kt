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
package com.binance4j.connectors.margin.client

import com.binance4j.connectors.core.Headers.API_H
import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.IS_ORDER_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.UID_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.margin.dto.*
import retrofit2.Call
import retrofit2.http.*

/**
 * [MarginClient] API mapping
 */
interface MarginMapping {
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 600")
	@POST("/sapi/v1/margin/transfer")
	fun transfer(@QueryMap map: Map<String, Any>): Call<Transaction>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@POST("/sapi/v1/margin/loan")
	fun borrow(@QueryMap map: Map<String, Any>): Call<Transaction>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 3000")
	@POST("/sapi/v1/margin/repay")
	fun repay(@QueryMap map: Map<String, Any>): Call<Transaction>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(API_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/asset")
	fun getAsset(@QueryMap map: Map<String, Any>): Call<Asset>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(API_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/pair")
	fun getCrossMarginPair(@QueryMap map: Map<String, Any>): Call<CrossSymbol>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(API_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/allPairs")
	fun getAllCrossMarginPairs(@QueryMap map: Map<String, Any>): Call<List<CrossSymbol>>
	
	/**
	 * @return The generated Retrofit call.
	 */
	@get:GET("/sapi/v1/margin/allAssets")
	@get:Headers(API_H, IP_H, WEIGHT_ONE_H)
	val allAssets: Call<List<Asset>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(API_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/priceIndex")
	fun getPriceIndex(@QueryMap map: Map<String, Any>): Call<PriceIndex>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 6", IS_ORDER_H)
	@POST("/sapi/v1/margin/order")
	fun newOrder(@QueryMap map: Map<String, Any>): Call<NewOrderRecord>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@DELETE("/sapi/v1/margin/order")
	fun cancelOrder(@QueryMap map: Map<String, Any>): Call<CancelOrderResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@DELETE("/sapi/v1/margin/openOrders")
	fun cancelOpenOrders(@QueryMap map: Map<String, Any>): Call<List<CancelOrderResponse>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/margin/transfer")
	fun getTransferHistory(@QueryMap map: Map<String, Any>): Call<TransferRecords>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/loan")
	fun getLoanRecord(@QueryMap map: Map<String, Any>): Call<LoanRecord>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/repay")
	fun getRepayRecord(@QueryMap map: Map<String, Any>): Call<RepayRecords>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/margin/interestHistory")
	fun getInterestHistory(@QueryMap map: Map<String, Any>): Call<InterestHistory>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/margin/forceLiquidationRec")
	fun getForceLiquidationRecord(@QueryMap map: Map<String, Any>): Call<ForceLiquidationRecords>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/account")
	fun getAccount(@QueryMap map: Map<String, Any>): Call<Account>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/order")
	fun getOrder(@QueryMap map: Map<String, Any>): Call<OrderInfo>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/openOrders")
	fun getOpenOrders(@QueryMap map: Map<String, Any>): Call<List<OrderInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 200")
	@GET("/sapi/v1/margin/allOrders")
	fun getAllOrders(@QueryMap map: Map<String, Any>): Call<List<OrderInfo>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, IS_ORDER_H, "X-WEIGHT: 6")
	@POST("/sapi/v1/margin/order/oco")
	fun newOCO(@QueryMap map: Map<String, Any>): Call<NewOCOOrderRecord>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, WEIGHT_ONE_H)
	@DELETE("/sapi/v1/margin/orderList")
	fun cancelOCO(@QueryMap map: Map<String, Any>): Call<NewOCOOrderRecord>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/orderList")
	fun getOCO(@QueryMap map: Map<String, Any>): Call<OCOOrderRecord>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 200")
	@GET("/sapi/v1/margin/allOrderList")
	fun getAllOCO(@QueryMap map: Map<String, Any>): Call<List<OCOOrderRecord>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/openOrderList")
	fun getOpenOCO(@QueryMap map: Map<String, Any>): Call<List<OCOOrderRecord>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/myTrades")
	fun getTrades(@QueryMap map: Map<String, Any>): Call<List<Trade>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 50")
	@GET("/sapi/v1/margin/maxBorrowable")
	fun getMaxBorrowable(@QueryMap map: Map<String, Any>): Call<MaxBorrowable>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 50")
	@GET("/sapi/v1/margin/maxTransferable")
	fun getMaxTransferable(@QueryMap map: Map<String, Any>): Call<MaxTransferable>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 600")
	@POST("/sapi/v1/margin/isolated/transfer")
	fun isolatedTransfer(@QueryMap map: Map<String, Any>): Call<Transaction>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/margin/isolated/transfer")
	fun getIsolatedTransferHistory(@QueryMap map: Map<String, Any>): Call<IsolatedTransferRecords>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/isolated/account")
	fun getIsolatedAccount(@QueryMap map: Map<String, Any>): Call<IsolatedAccount>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 300")
	@DELETE("/sapi/v1/margin/isolated/account")
	fun disableIsolatedAccount(@QueryMap map: Map<String, Any>): Call<ToogleAccountResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 300")
	@POST("/sapi/v1/margin/isolated/account")
	fun enableIsolatedAccount(@QueryMap map: Map<String, Any>): Call<ToogleAccountResponse>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 1")
	@GET("/sapi/v1/margin/isolated/accountLimit")
	fun getEnabledIsolatedAccountLimit(@QueryMap map: Map<String, Any>): Call<IsolatedAccountLimit>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/isolated/pair")
	fun getIsolatedSymbol(@QueryMap map: Map<String, Any>): Call<IsolatedSymbol>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/isolated/allPairs")
	fun getAllIsolatedSymbols(@QueryMap map: Map<String, Any>): Call<List<IsolatedSymbol>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/bnbBurn")
	fun toggleBNBBurnOnSpotTradeAndMarginInterest(@QueryMap map: Map<String, Any>): Call<BNBBurnStatus>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/bnbBurn")
	fun getBNBBurnStatus(@QueryMap map: Map<String, Any>): Call<BNBBurnStatus>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/margin/interestRateHistory")
	fun getInterestRateHistory(@QueryMap map: Map<String, Any>): Call<List<InterestRate>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 5")
	@GET("/sapi/v1/margin/crossMarginData")
	fun getMarginFeeData(@QueryMap map: Map<String, Any>): Call<List<CrossFee>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/margin/isolatedMarginData")
	fun getIsolatedFeeData(@QueryMap map: Map<String, Any>): Call<List<IsolatedFee>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 1")
	@GET("/sapi/v1/margin/isolatedMarginTier")
	fun getIsolatedMarginTierData(@QueryMap map: Map<String, Any>): Call<List<IsolatedTierData>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 20")
	@GET("/sapi/v1/margin/rateLimit/order")
	fun getRateLimit(@QueryMap map: Map<String, Any>): Call<List<OrderRateLimit>>
	
	/**
	 * @param map Query map.
	 *
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 1")
	@GET("/sapi/v1/margin/dribblet")
	fun getDustLog(@QueryMap map: Map<String, Any>): Call<DustLogRecord>
}