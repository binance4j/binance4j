package com.binance4j.connectors.loan.client

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.loan.dto.LoanIncomeType
import org.junit.jupiter.api.Test

internal class LoanClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).loan

    @Test
    fun `Get loans income`() = LoanIncomeType.values().forEach { type -> assertDoesNotThrow(client.getLoansIncome(asset, type)) }

    @Test
    fun `Get loans income with interval`() = assertDoesNotThrow(client.getLoansIncome(asset, LoanIncomeType.REMOVE_COLLATERAL, lastYear, today, limit))
}