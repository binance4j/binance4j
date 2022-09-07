package com.binance4j.connectors.pay.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class PayClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).pay

    @Test
    fun getTrades() = assertDoesNotThrow(client.getTrades(lastHour, today, limit))
}