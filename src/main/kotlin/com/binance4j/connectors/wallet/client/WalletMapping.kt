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
 * furnished to do so, subject to the following@Query("conditions") conditions:
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
package com.binance4j.connectors.wallet.client

import com.binance4j.connectors.core.Headers.IP_H
import com.binance4j.connectors.core.Headers.SIGNED_H
import com.binance4j.connectors.core.Headers.UID_H
import com.binance4j.connectors.core.Headers.WEIGHT_ONE_H
import com.binance4j.connectors.wallet.client.WalletClient.getAllCoinsInfo
import com.binance4j.connectors.wallet.dto.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Binance Wallet endpoints mapping.
 */
interface WalletMapping {
    /**
     * Fetch the system status.
     *
     * @return The generated Retrofit call.
     */
    @GET("/sapi/v1/system/status")
    @Headers(IP_H, WEIGHT_ONE_H)
    fun getSystemStatus(): Call<SystemStatus>

    /**
     * Get the information of coins (available for deposit and withdraw) for user.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/sapi/v1/capital/config/getall")
    fun getAllCoinsInfo(): Call<List<CoinInformation>>

    /**
     * Fetch the daily SPOT account snapshots.
     *
     * @param type        Snapshot type.
     * @param startTime   Start time in ms.
     * @param endTime     End time in ms.
     * @param limit       Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
    @GET("/sapi/v1/accountSnapshot")
    fun getSpotAccountSnapshot(
        @Query("type") type: AccountSnapshotType,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?
    ): Call<SpotAccountSnapshotResponse>

    /**
     * Fetch the daily MARGIN account snapshots.
     *
     * @param type        Snapshot type.
     * @param startTime   Start time in ms.
     * @param endTime     End time in ms.
     * @param limit       Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
    @GET("/sapi/v1/accountSnapshot")
    fun getMarginAccountSnapshot(
        @Query("type") type: AccountSnapshotType, @Query("startTime") startTime: Long?, @Query("endTime") endTime: Long?, @Query("limit") limit: Int?
    ): Call<MarginAccountSnapshotResponse>

    /**
     * Fetch the daily FUTURES account snapshots.
     *
     * @param type        Snapshot type.
     * @param startTime   Start time in ms.
     * @param endTime     End time in ms.
     * @param limit       Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 2400")
    @GET("/sapi/v1/accountSnapshot")
    fun getFuturesAccountSnapshot(
        @Query("type") type: AccountSnapshotType,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?
    ): Call<FuturesAccountSnapshotResponse>

    /**
     * Disable fast withdraw switch under your account.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/account/disableFastWithdrawSwitch")
    fun disableFastWithdrawSwitch(): Call<Unit>

    /**
     * Enable fast withdraw switch under your account.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/account/enableFastWithdrawSwitch")
    fun enableFastWithdrawSwitch(): Call<Unit>

    /**
     * Submits a withdrawal request. If network not send, you can get `network` and `isDefault` in networkList of a coin in the response of [getAllCoinsInfo]
     *
     * @param amount            The volume.
     * @param coin              The coin to withdraw.
     * @param address           The destination address.
     * @param withdrawOrderId   Client id for withdraw.
     * @param network           The network to use.
     * @param addressTag        Secondary address identifier for coins like XRP,XMR etc.
     * @param transactionFeeFlag When making internal transfer, true for returning the fee to the destination account; false for returning the fee back to
     * the departure account. Default false.
     * @param name              Description of the address. Space in name should be encoded into %20.
     * @param walletType        The wallet type for withdraw.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/capital/withdraw/apply")
    fun withdraw(
        @Query("coin") coin: String,
        @Query("address") address: String,
        @Query("amount") amount: String,
        @Query("withdrawOrderId") withdrawOrderId: String?,
        @Query("network") network: String?,
        @Query("addressTag") addressTag: String?,
        @Query("transactionFeeFlag") transactionFeeFlag: Boolean?,
        @Query("name") name: String?,
        @Query("walletType") walletType: String?,
    ): Call<WithdrawResult>

    /**
     * Fetches the deposit history of one or multiple coins.
     *
     * @param coin   Deposited coin.
     * @param status Deposit status.
     * @param startTime  Start time in ms.
     * @param endTime    End time in ms.
     * @param offset      Results page.
     * @param limit      Page size.
     * @param txId  Transaction id.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/capital/deposit/hisrec")
    fun getDepositHistory(
        @Query("coin") coin: String?,
        @Query("status") status: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?,
        @Query("txId") txId: String?
    ): Call<List<DepositHistory>>

    /**
     * Fetches the withdrawal history of one or multiple coins.
     *
     * @param coin              Coin we want the history.
     * @param withdrawOrderId   Withdraw order id to fetch.
     * @param status            Status to look for. * @param startTime Start time in ms.
     * @param endTime           End time in ms.
     * @param offset            Result page.
     * @param limit             Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/capital/withdraw/history")
    fun getWithdrawHistory(
        @Query("status") status: String?,
        @Query("coin") coin: String?,
        @Query("withdrawOrderId") withdrawOrderId: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("offset") offset: Int?,
        @Query("limit") limit: Int?
    ): Call<List<WithdrawHistory>>

    /**
     * Fetches deposit address
     *
     * @param coin    Coin abbreviation.
     * @param network Transfer network.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/sapi/v1/capital/deposit/address")
    fun getDepositAddress(@Query("coin") coin: String, @Query("network") network: String?): Call<DepositAddress>

    /**
     * Fetches the account status detail.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/account/status")
    fun getAccountStatus(): Call<AccountStatus>

    /**
     * Fetches the account api trading status detail.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/account/apiTradingStatus")
    fun getApiTradingStatus(): Call<ApiTradingStatus>

    /**
     * Fetches the dust transfer logs.
     *
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/asset/dribblet")
    fun getDustLog(@Query("startTime") startTime: Long?, @Query("endTime") endTime: Long?, @Query("limit") limit: Int?): Call<DustLog>

    /**
     * Retrieves the assets convertible into BNB.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/asset/dust-btc")
    fun getConvertibleAssets(): Call<ConvertibleAssets>

    /**
     * Convert dust assets to BNB.
     *
     * @param assets List of assets to convert into BNB.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, UID_H, "X-WEIGHT: 10")
    @POST("/sapi/v1/asset/dust")
    fun dustTransfer(@Query("assets") assets: List<String>): Call<DustTransferResponse>

    /**
     * Get the dividend record of one or multiple assets.
     *
     * @param asset  Asset.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, "X-WEIGHT: 10")
    @GET("/sapi/v1/asset/assetDividend")
    fun getAssetDividendRecord(
        @Query("asset") asset: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("limit") limit: Int?
    ): Call<AssetDividendRecord>

    /**
     * Fetches the details of an asset supported on Binance. Please get network and
     * other deposit or withdraw details from [getAllCoinsInfo].
     *
     * @param asset Asset abbreviation.
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/asset/assetDetail")
    fun getAssetDetail(@Query("asset") asset: String?): Call<Map<String, AssetDetail>>

    /**
     * Fetches the trade fee.
     *
     * @param symbol Trading pair we want the fees.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/asset/tradeFee")
    fun getTradeFee(@Query("symbol") symbol: String?): Call<List<TradeFee>>

    /**
     * Make a universal transfer.
     *
     * @param asset      Asset.
     * @param type       Transfer type.
     * @param amount     Volume.
     * @param fromSymbol Mandatory when `ISOLATEDMARGIN_MARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     * @param toSymbol   Mandatory when `ISOLATEDMARGIN_MARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/asset/transfer")
    fun transfer(
        @Query("asset") asset: String,
        @Query("type") type: WalletTransferType,
        @Query("amount") amount: String,
        @Query("fromSymbol") fromSymbol: String?,
        @Query("toSymbol") toSymbol: String?
    ): Call<WalletTransferResponse>

    /**
     * Fetches the user universal transfer history
     *
     * @param type       User universal transfer type.
     * @param fromSymbol Mandatory when `ISOLATEDMARGIN_MARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     * @param toSymbol   Mandatory when `MARGIN_ISOLATEDMARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param page      Result page.
     * @param limit     Results in the page.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/asset/transfer")
    fun getTransferHistory(
        @Query("type") type: WalletTransferType,
        @Query("fromSymbol") fromSymbol: String?,
        @Query("toSymbol") toSymbol: String?,
        @Query("startTime") startTime: Long?,
        @Query("endTime") endTime: Long?,
        @Query("page") page: Int?,
        @Query("limit") limit: Int?
    ): Call<WalletTransferHistory>

    /**
     * Fetches the funding wallet asset balance.
     *
     * @param asset            Asset we want the balance.
     * @param needBtcValuation Get the BTC value of the asset.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @POST("/sapi/v1/asset/get-funding-asset")
    fun getFundingWallet(asset: String?, @Query("needBtcValuation") needBtcValuation: Boolean?): Call<List<FundingAsset>>

    /**
     * Fetches the API Key Permission.
     *
     * @return The generated Retrofit call.
     */
    @Headers(SIGNED_H, IP_H, WEIGHT_ONE_H)
    @GET("/sapi/v1/account/apiRestrictions")
    fun getApiPermissions(): Call<ApiPermissions>
}