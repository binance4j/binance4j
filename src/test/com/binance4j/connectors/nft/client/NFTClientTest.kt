package com.binance4j.connectors.nft.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.nft.dto.OrderType
import org.junit.jupiter.api.Test

internal class NFTClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).nft

    @Test
    fun `Get all transactions`() = OrderType.values().forEach { type -> assertDoesNotThrow(client.getTransactions(type)) }

    @Test
    fun `Get all transactions in an interval`() = OrderType.values().forEach { type ->
        assertDoesNotThrow(client.getTransactions(type, lastYear, today, 1, limit))
    }

    @Test
    fun `Get deposits in interval`() = assertDoesNotThrow(client.getDeposits(lastYear, today, 1, limit))

    @Test
    fun `Get withdraws in interval`() = assertDoesNotThrow(client.getWithdraws(lastYear, today, 1, limit))

    @Test
    fun `Get assets in interval`() = assertDoesNotThrow(client.getAssets(1, limit))
}