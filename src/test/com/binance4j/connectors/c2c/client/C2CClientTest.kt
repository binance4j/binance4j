package com.binance4j.connectors.c2c.client

import com.binance4j.connectors.RestConnectors.key
import com.binance4j.connectors.RestConnectors.secret
import com.binance4j.connectors.c2c.dto.TradeType
import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class C2CClientTest :CustomTest(){
    private var client = Connectors.rest(key,secret).c2c

    @Test
    fun `Get trades by type`() {
       assertDoesNotThrow(client.getTrades(TradeType.BUY))
    }

    @Test
    fun `Get trades by type and page`() {
       assertDoesNotThrow(client.getTrades(TradeType.BUY,1))
    }

    @Test
    fun `Get trades by type, page and limit`() {
       assertDoesNotThrow(client.getTrades(TradeType.BUY,1, 25))
    }
}