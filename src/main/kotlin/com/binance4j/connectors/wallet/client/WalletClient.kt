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

package com.binance4j.connectors.wallet.client

import com.binance4j.connectors.core.Request
import com.binance4j.connectors.core.client.RestClient
import com.binance4j.connectors.wallet.dto.*

/**
 * The API client for the wallet endpoints.
 *
 * [Documentation](https://binance-docs.github.io/apidocs/spot/en/#wallet-endpoints)
 */
object WalletClient : RestClient<WalletMapping>(WalletMapping::class.java) {
    /**
     * Fetches the system status.
     *
     * @return The request to execute.
     */
    fun getSystemStatus() = Request(service.getSystemStatus())

    /**
     * Gets the information of coins (available for deposit and withdraw) for user.
     *
     * @return The request to execute.
     */
    fun getAllCoinsInfo() = Request(service.getAllCoinsInfo())

    /**
     * Fetches the daily SPOT account snapshots.
     *
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getSpotAccountSnapshot(startTime: Long? = null, endTime: Long? = null, limit: Int? = null) = Request(
        service.getSpotAccountSnapshot(AccountSnapshotType.SPOT, startTime, endTime, limit)
    )

    /**
     * Fetches the daily MARGIN account snapshots.
     *
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getMarginAccountSnapshot(startTime: Long? = null, endTime: Long? = null, limit: Int? = null) = Request(
        service.getMarginAccountSnapshot(AccountSnapshotType.MARGIN, startTime, endTime, limit)
    )

    /**
     * Fetches the daily FUTURES account snapshots.
     *
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFuturesAccountSnapshot(startTime: Long? = null, endTime: Long? = null, limit: Int? = null) = Request(
        service.getFuturesAccountSnapshot(AccountSnapshotType.FUTURES, startTime, endTime, limit)
    )

    /**
     * Disables fast withdraw switch under your account.
     *
     * @return The request to execute.
     */
    fun disableFastWithdrawSwitch() = Request(service.disableFastWithdrawSwitch())

    /**
     * Enables fast withdraw switch under your account.
     *
     * @return The request to execute.
     */
    fun enableFastWithdrawSwitch() = Request(service.enableFastWithdrawSwitch())

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
     * @return The request to execute.
     */
    @JvmOverloads
    fun withdraw(
        coin: String,
        address: String,
        amount: String,
        withdrawOrderId: String? = null,
        network: String? = null,
        addressTag: String? = null,
        transactionFeeFlag: Boolean? = null,
        name: String? = null,
        walletType: WalletType? = null,
    ) = Request(service.withdraw(coin, address, amount, withdrawOrderId, network, addressTag, transactionFeeFlag, name, walletType.toString()))

    /**
     * Fetches the deposit history of one or multiple coins.
     *
     * @param coin          Deposited coin.
     * @param status        Deposit status.
     * @param startTime     Start time in ms.
     * @param endTime       End time in ms.
     * @param offset        Results page.
     * @param limit         Page size.
     * @param txId          Transaction id.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getDepositHistory(
        coin: String? = null,
        status: DepositStatus? = null,
        startTime: Long? = null,
        endTime: Long? = null,
        offset: Int? = null,
        limit: Int? = null,
        txId: String? = null
    ) = Request(service.getDepositHistory(coin, status.toString(), startTime, endTime, offset, limit, txId))

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
     * @return The request to execute.
     */
    @JvmOverloads
    fun getWithdrawHistory(
        status: WithdrawStatus?,
        coin: String? = null,
        withdrawOrderId: String? = null,
        startTime: Long? = null,
        endTime: Long? = null,
        offset: Int? = null,
        limit: Int? = null
    ) = Request(service.getWithdrawHistory(status.toString(), coin, withdrawOrderId, startTime, endTime, offset, limit))

    /**
     * Fetches deposit address
     *
     * @param coin    Coin abbreviation.
     * @param network Transfer network.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getDepositAddress(coin: String, network: String? = null) = Request(service.getDepositAddress(coin, network))

    /**
     * Fetches the account status detail.
     *
     * @return The request to execute.
     */
    fun getAccountStatus() = Request(service.getAccountStatus())

    /**
     * Fetches the account api trading status detail.
     *
     * @return The request to execute.
     */
    fun getApiTradingStatus() = Request(service.getApiTradingStatus())

    /**
     * Fetches the dust transfer logs.
     *
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getDustLog(startTime: Long? = null, endTime: Long? = null, limit: Int? = null) = Request(service.getDustLog(startTime, endTime, limit))

    /**
     * Retrieves the assets convertible into BNB.
     *
     * @return The request to execute.
     */
    fun getConvertibleAssets() = Request(service.getConvertibleAssets())

    /**
     * Convert dust assets to BNB.
     *
     * @param assets List of assets to convert into BNB.
     *
     * @return The request to execute.
     */
    fun dustTransfer(assets: List<String>) = Request(service.dustTransfer(assets))

    /**
     * Get the dividend record of one or multiple assets.
     *
     * @param asset  Asset.
     * @param startTime Start time in ms.
     * @param endTime   End time in ms.
     * @param limit     Results limit.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAssetDividendRecord(asset: String? = null, startTime: Long? = null, endTime: Long? = null, limit: Int? = null) =
        Request(service.getAssetDividendRecord(asset, startTime, endTime, limit))

    /**
     * Fetches the details of an asset supported on Binance. Please get network and
     * other deposit or withdraw details from [getAllCoinsInfo].
     *
     * @param asset Asset abbreviation.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getAssetDetail(asset: String? = null) = Request(service.getAssetDetail(asset))

    /**
     * Fetches the trade fee.
     *
     * @param symbol Trading pair we want the fees.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTradeFee(symbol: String? = null) = Request(service.getTradeFee(symbol))

    /**
     * Make a universal transfer.
     *
     * @param asset      Asset.
     * @param type       Transfer type.
     * @param amount     Volume.
     * @param fromSymbol Mandatory when `ISOLATEDMARGIN_MARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     * @param toSymbol   Mandatory when `ISOLATEDMARGIN_MARGIN` and `ISOLATEDMARGIN_ISOLATEDMARGIN`.
     *
     * @return The request to execute.
     */
    fun transfer(asset: String, type: WalletTransferType, amount: String, fromSymbol: String? = null, toSymbol: String? = null) =
        Request(service.transfer(asset, type, amount, fromSymbol, toSymbol))

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
     * @return The request to execute.
     */
    @JvmOverloads
    fun getTransferHistory(
        type: WalletTransferType,
        fromSymbol: String? = null,
        toSymbol: String? = null,
        startTime: Long? = null,
        endTime: Long? = null,
        page: Int? = null,
        limit: Int? = null
    ) = Request(service.getTransferHistory(type, fromSymbol, toSymbol, startTime, endTime, page, limit))

    /**
     * Fetches the funding wallet asset balance.
     *
     * @param asset            Asset we want the balance.
     * @param needBtcValuation Get the BTC value of the asset.
     *
     * @return The request to execute.
     */
    @JvmOverloads
    fun getFundingWallet(asset: String? = null, needBtcValuation: Boolean? = null) = Request(service.getFundingWallet(asset, needBtcValuation))

    /**
     * Fetches the API Key Permission.
     *
     * @return The request to execute.
     */
    fun getApiPermissions() = Request(service.getApiPermissions())
}