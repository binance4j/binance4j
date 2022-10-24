package com.binance4j.connectors.convert.client

import com.binance4j.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class ConvertClientTest : CustomTest() {
    private var client = Connectors.rest(key, secret).convert

    @Test
    fun getConversions() = assertDoesNotThrow(client.getConversions(lastYear, today, limit))
}