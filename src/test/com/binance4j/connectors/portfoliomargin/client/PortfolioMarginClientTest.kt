package com.binance4j.connectors.portfoliomargin.client

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class PortfolioMarginClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).portfolio

    //@Test TODO Don't have account ...
    //fun getAccountInfo() = assertDoesNotThrow(client.getAccountInfo())

    @Test
    fun getCollateralRate() = assertDoesNotThrow(client.getCollateralRate())

    @Test
    fun getBankruptcyLoanAmount() = assertDoesNotThrow(client.getBankruptcyLoanAmount())

    //@Test TODO can't repay, no account.
    //fun repay() = assertDoesNotThrow(client.repay())
}