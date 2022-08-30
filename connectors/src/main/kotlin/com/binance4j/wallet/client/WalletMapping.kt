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
package com.binance4j.wallet.client

import com.binance4j.core.Binance4j.IP_H
import com.binance4j.core.Binance4j.SIGNED_H
import com.binance4j.core.Binance4j.UID_H
import com.binance4j.core.Binance4j.WEIGHT_ONE_H
import com.binance4j.wallet.dto.*
import retrofit2.Call
import retrofit2.http.*

/**
 * Binance Wallet endpoints mapping.
 */
interface WalletMapping {
	/**
	 * @return The generated Retrofit call.
	 */
	@GET("/sapi/v1/system/status")
	@Headers(IP_H, WEIGHT_ONE_H)
	@JvmSuppressWildcards
	fun getSystemStatus(): Call<SystemStatus>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/capital/config/getall")
	@JvmSuppressWildcards
	fun getAllCoinsInfo(@QueryMap map: Map<String, Any>): Call<List<CoinInformation>>
	
	/**
	 * @param type Snapshot type.
	 * @param map  Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
	@GET("/sapi/v1/accountSnapshot")
	@JvmSuppressWildcards
	fun getSpotAccountSnapshot(
		@Query("type") type: AccountSnapshotType,
		@QueryMap map: Map<String, Any>
	): Call<SpotAccountSnapshotResponse>
	
	/**
	 * @param type Snapshot type.
	 * @param map  Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
	@GET("/sapi/v1/accountSnapshot")
	@JvmSuppressWildcards
	fun getMarginAccountSnapshot(
		@Query("type") type: AccountSnapshotType,
		@QueryMap map: Map<String, Any>
	): Call<MarginAccountSnapshotResponse>
	
	/**
	 * @param type Snapshot type.
	 * @param map  Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
	@GET("/sapi/v1/accountSnapshot")
	@JvmSuppressWildcards
	fun getFuturesAccountSnapshot(
		@Query("type") type: AccountSnapshotType,
		@QueryMap map: Map<String, Any>
	): Call<FuturesAccountSnapshotResponse>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/account/disableFastWithdrawSwitch")
	@JvmSuppressWildcards
	fun disableFastWithdrawSwitch(@QueryMap map: Map<String, Any>): Call<Unit>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/account/enableFastWithdrawSwitch")
	@JvmSuppressWildcards
	fun enableFastWithdrawSwitch(@QueryMap map: Map<String, Any>): Call<Unit>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/capital/withdraw/apply")
	@JvmSuppressWildcards
	fun withdraw(@QueryMap map: Map<String, Any>): Call<WithdrawResult>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/capital/deposit/hisrec")
	@JvmSuppressWildcards
	fun getDepositHistory(@QueryMap map: Map<String, Any>): Call<List<DepositHistory>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/capital/withdraw/history")
	@JvmSuppressWildcards
	fun getWithdrawHistory(@QueryMap map: Map<String, Any>): Call<List<WithdrawHistory>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/capital/deposit/address")
	@JvmSuppressWildcards
	fun getDepositAddress(@QueryMap map: Map<String, Any>): Call<DepositAddress>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/account/status")
	@JvmSuppressWildcards
	fun getAccountstatus(@QueryMap map: Map<String, Any>): Call<AccountStatus>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/account/apiTradingStatus")
	@JvmSuppressWildcards
	fun getApiTradingStatus(@QueryMap map: Map<String, Any>): Call<ApiTradingStatus>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/asset/dribblet")
	@JvmSuppressWildcards
	fun getDustLog(@QueryMap map: Map<String, Any>): Call<DustLog>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/asset/dust-btc")
	@JvmSuppressWildcards
	fun getConvertibleAssets(@QueryMap map: Map<String, Any>): Call<ConvertibleAssets>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, UID_H, "X-WEIGHT: 10")
	@POST("/sapi/v1/asset/dust")
	@JvmSuppressWildcards
	fun dustTransfer(@QueryMap map: Map<String, Any>): Call<DustTransferResponse>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
	@GET("/sapi/v1/asset/assetDividend")
	@JvmSuppressWildcards
	fun getAssetDividendRecord(@QueryMap map: Map<String, Any>): Call<AssetDividendRecord>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/asset/assetDetail")
	@JvmSuppressWildcards
	fun getAssetDetail(@QueryMap map: Map<String, Any>): Call<Map<String, AssetDetail>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/asset/tradeFee")
	@JvmSuppressWildcards
	fun getTradeFee(@QueryMap map: Map<String, Any>): Call<List<TradeFee>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/asset/transfer")
	@JvmSuppressWildcards
	fun transfer(@QueryMap map: Map<String, Any>): Call<WalletTransferResponse>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/asset/transfer")
	@JvmSuppressWildcards
	fun getTransferHistory(@QueryMap map: Map<String, Any>): Call<WalletTransferHistory>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@POST("/sapi/v1/asset/get-funding-asset")
	@JvmSuppressWildcards
	fun getFundingWallet(@QueryMap map: Map<String, Any>): Call<List<FundingAsset>>
	
	/**
	 * @param map Query map.
	 * @return The generated Retrofit call.
	 */
	@Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
	@GET("/sapi/v1/account/apiRestrictions")
	@JvmSuppressWildcards
	fun getApiPermissions(@QueryMap map: Map<String, Any>): Call<ApiPermissions>
}