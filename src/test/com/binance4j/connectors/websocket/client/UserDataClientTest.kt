package com.binance4j.connectors.websocket.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

internal class UserDataClientTest : CustomTest() {
    val client: UserDataClient = Connectors.rest(key, secret).user

    @Test
    @Throws(ApiException::class)
    fun testUserDataStream() {
        val listenKey = client.startUserDataStream().sync()
        assertNotNull(listenKey)
        assertDoesNotThrow(client.keepAliveUserDataStream(listenKey.listenKey))
        assertDoesNotThrow(client.closeUserDataStream(listenKey.listenKey))
    }

    @Test
    @Throws(ApiException::class)
    fun testMarginUserDataStream() {
        val listenKey = client.startMarginUserDataStream().sync()
        Assertions.assertTrue(listenKey.listenKey.isNotEmpty())
        assertDoesNotThrow(client.keepAliveMarginUserDataStream(listenKey.listenKey))
        assertDoesNotThrow(client.closeMarginUserDataStream(listenKey.listenKey))
    }

    @Test
    fun testIsolatedUserDataStream() {
        val isolatedSymbol = "BTCUSDT"
        val listenKey = client.startIsolatedUserDataStream(isolatedSymbol).sync()
        Assertions.assertTrue(listenKey.listenKey.isNotEmpty())
        assertDoesNotThrow(client.keepAliveIsolatedUserDataStream(isolatedSymbol, listenKey.listenKey))
        assertDoesNotThrow(client.closeIsolatedUserDataStream(isolatedSymbol, listenKey.listenKey))
    }
}