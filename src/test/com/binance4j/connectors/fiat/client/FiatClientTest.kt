package com.binance4j.connectors.fiat.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.fiat.dto.PaymentType
import com.binance4j.connectors.fiat.dto.TransactionType
import org.junit.jupiter.api.Test

internal class FiatClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).fiat

    @Test
    fun `Get transactions by type`() = assertDoesNotThrow(client.getTransactions(TransactionType.DEPOSIT))

    @Test
    fun `Get transactions by type and interval`() = assertDoesNotThrow(client.getTransactions(TransactionType.DEPOSIT, lastYear, today, 1, 25))

    @Test
    fun `Get payments by type`() = assertDoesNotThrow(client.getPayments(PaymentType.BUY))

    @Test
    fun `Get payments by type and interval`() = assertDoesNotThrow(client.getPayments(PaymentType.BUY, lastYear, today, 1, 25))
}