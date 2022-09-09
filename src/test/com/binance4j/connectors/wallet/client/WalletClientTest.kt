package com.binance4j.connectors.wallet.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.wallet.dto.DepositStatus
import com.binance4j.connectors.wallet.dto.WalletTransferType
import org.junit.jupiter.api.Test

internal class WalletClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).wallet

    @Test
    fun `Get system status`() = assertDoesNotThrow(client.getSystemStatus())

    @Test
    fun `Get all coins info`() = assertDoesNotThrow(client.getAllCoinsInfo())

    @Test
    fun `Get spot account snapshot`() = assertDoesNotThrow(client.getSpotAccountSnapshot())

    @Test
    fun `Get margin account snapshot`() = assertDoesNotThrow(client.getMarginAccountSnapshot())

    @Test
    fun `Get futures account snapshot`() = assertDoesNotThrow(client.getFuturesAccountSnapshot())

    @Test
    fun `Disable fast withdraw switch`() = assertDoesNotThrow(client.disableFastWithdrawSwitch())

    @Test
    fun `Enable fast withdraw switch`() = assertDoesNotThrow(client.enableFastWithdrawSwitch())

    //@Test unquote to test
    //fun withdraw() = assertDoesNotThrow(client.withdraw("coin", "address", "amount"))

    @Test
    fun `Get deposit history`() = assertDoesNotThrow(client.getDepositHistory(DepositStatus.SUCCESS, asset))

    @Test
    fun `Get withdraw history`() = assertDoesNotThrow(client.getWithdrawHistory(coin = asset))

    @Test
    fun `Get deposit address`() = assertDoesNotThrow(client.getDepositAddress(coin = asset))

    @Test
    fun getAccountStatus() = assertDoesNotThrow(client.getAccountStatus())

    @Test
    fun getApiTradingStatus() = assertDoesNotThrow(client.getApiTradingStatus())

    @Test
    fun getDustLog() = assertDoesNotThrow(client.getDustLog())

    @Test
    fun getConvertibleAssets() = assertDoesNotThrow(client.getConvertibleAssets())

    //@Test unquote to test
    //fun dustTransfer() = assertDoesNotThrow(client.dustTransfer(assets))

    @Test
    fun getAssetDividendRecord() = assertDoesNotThrow(client.getAssetDividendRecord())

    @Test
    fun getAssetDetail() = assertDoesNotThrow(client.getAssetDetail())

    @Test
    fun getTradeFee() = assertDoesNotThrow(client.getTradeFee())

    //@Test TODO unquote to test
    //fun transfer() = assertDoesNotThrow(client.transfer(asset,WalletTransferType.MAIN_MARGIN,"amount"))

    @Test
    fun getTransferHistory() = assertDoesNotThrow(client.getTransferHistory(WalletTransferType.MAIN_MARGIN))

    @Test
    fun getFundingWallet() = assertDoesNotThrow(client.getFundingWallet())

    @Test
    fun getApiPermissions() = assertDoesNotThrow(client.getApiPermissions())
}