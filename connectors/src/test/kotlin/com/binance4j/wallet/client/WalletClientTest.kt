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

import com.binance4j.core.client.RestClient
import com.binance4j.core.exception.ApiException
import com.binance4j.core.param.TimeFrame
import com.binance4j.core.test.CustomTest
import com.binance4j.wallet.dto.DepositStatus
import com.binance4j.wallet.dto.WalletTransferType
import com.binance4j.wallet.dto.WithdrawStatus
import com.binance4j.wallet.param.*
import com.fasterxml.jackson.databind.DeserializationFeature
import org.junit.jupiter.api.Test

class WalletClientTest : CustomTest() {
    private var client = WalletClient(key, secret)

    @Test
    @Throws(ApiException::class)
    fun testDisableFastWithdrawSwitch() {
        assertNotThrow(client.disableFastWithdrawSwitch())
    }

    @Test
    @Throws(ApiException::class)
    fun testEnableFastWithdrawSwitch() {
        assertNotThrow(client.enableFastWithdrawSwitch())
    }

    // TODO @Test
    @Throws(ApiException::class)
    fun testdustTransfer() {
        assertNotThrow(client.dustTransfer(DustTransferParams(assets)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAccountstatus() {
        assertNotThrow(client.getAccountStatus())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAllCoinsInfo() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getAllCoinsInfo())
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetApiPermissions() {
        assertNotThrow(client.getApiPermissions())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetApiTradingStatus() {
        assertNotThrow(client.getApiTradingStatus())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAssetDetail() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getAssetDetail())
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAssetDetail2() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getAssetDetail(AssetDetailParams(asset)))
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAssetDividendRecord() {
        assertNotThrow(client.getAssetDividendRecord())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAssetDividendRecord2() {
        assertNotThrow(client.getAssetDividendRecord(AssetDividendRecordParams(asset)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetAssetDividendRecord3() {
        assertNotThrow(client.getAssetDividendRecord(AssetDividendRecordParams(asset), TimeFrame(limit.toLong())))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetConvertibleAssets() {
        assertNotThrow(client.getConvertibleAssets())
    }

    // @Test OK but restricted on GitHub Actions (USA?)
    @Throws(ApiException::class)
    fun testGetDepositAddress() {
        assertNotThrow(client.getDepositAddress(DepositAddressParams("BNB")))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDepositHistory() {
        assertNotThrow(client.getDepositHistory())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDepositHistory2() {
        assertNotThrow(client.getDepositHistory(DepositHistoryParams(asset)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDepositHistory3() {
        assertNotThrow(client.getDepositHistory(DepositHistoryParams(DepositStatus.SUCCESS)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDepositHistory4() {
        assertNotThrow(client.getDepositHistory(DepositHistoryParams(asset, DepositStatus.SUCCESS)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDustLog() {
        assertNotThrow(client.getDustLog())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetDustLog2() {
        assertNotThrow(client.getDustLog(TimeFrame(10)))
    }

    @Test
    @Throws(ApiException::class)
    fun testgetFundingWallet() {
        assertNotThrow(client.getFundingWallet())
    }

    @Test
    @Throws(ApiException::class)
    fun testgetFundingWallet2() {
        assertNotThrow(client.getFundingWallet(FundingWalletParams(asset)))
    }

    @Test
    @Throws(ApiException::class)
    fun testgetFundingWallet3() {
        assertNotThrow(client.getFundingWallet(FundingWalletParams(asset, true)))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetFuturesAccountSnapshot() {
        assertNotThrow(client.getFuturesAccountSnapshot())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetFuturesAccountSnapshot2() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getFuturesAccountSnapshot(TimeFrame(limit.toLong())))
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetMarginAccountSnapshot() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getMarginAccountSnapshot(TimeFrame(limit.toLong())))
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSpotAccountSnapshot() {
        assertNotThrow(client.getSpotAccountSnapshot())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSpotAccountSnapshot2() {
        assertNotThrow(client.getSpotAccountSnapshot(TimeFrame(limit.toLong())))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetSystemStatus() {
        assertNotThrow(client.getSystemStatus())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTradeFee() {
        assertNotThrow(client.getTradeFee())
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTradeFee2() {
        assertNotThrow(client.getTradeFee(TradeFeeParams("BNBBTC")))
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTransferHistory() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getTransferHistory(WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN)))
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetTransferHistory2() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(
            client.getTransferHistory(WalletTransferHistoryParams(WalletTransferType.MAIN_MARGIN, asset, asset))
        )
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetWithdrawHistory() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getWithdrawHistory())
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testGetWithdrawHistory2() {
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false)
        assertNotThrow(client.getWithdrawHistory(WithdrawHistoryParams("FTM", null, WithdrawStatus.COMPLETED)))
        RestClient.mapper().configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, true)
    }

    @Test
    @Throws(ApiException::class)
    fun testTransfer() {
    }

    // @Test
    @Throws(ApiException::class)
    fun testWithdraw() {
        assertNotThrow(client.withdraw(WithdrawParams("amount", "coin", "address")))
    }
}