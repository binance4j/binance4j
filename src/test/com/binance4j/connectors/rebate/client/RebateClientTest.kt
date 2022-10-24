package com.binance4j.connectors.rebate.client

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class RebateClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).rebate

    @Test
    fun `Get All Spot Rebate History Records`() = assertDoesNotThrow(client.getSpotRebateHistoryRecords())

    @Test
    fun `Get All Spot Rebate History Records in an interval`() = assertDoesNotThrow(client.getSpotRebateHistoryRecords(lastHour, today, 1, limit))
}