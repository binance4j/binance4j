package com.binance4j.connectors.websocket.client

import com.binance4j.connectors.core.dto.CandlestickInterval
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.test.CustomTest
import com.binance4j.connectors.websocket.callback.WebsocketCallback
import com.binance4j.connectors.websocket.callback.WebsocketCloseObject
import com.binance4j.connectors.websocket.dto.*
import okhttp3.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.concurrent.CompletableFuture

class WebsocketClientsTest : CustomTest() {

    @Test
    fun testWebsocketAggTradeClient() {
        val callback: TestCallback<AggTrade> = TestCallback()
        val client = WebsocketAggTradeClient(symbol, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketAllBookTickersClient() {
        val callback: TestCallback<BookTicker> = TestCallback()
        val client = WebsocketAllBookTickersClient(callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketAllMiniTickersClient() {
        val callback: TestCallback<MiniTicker> = TestCallback()
        val client = WebsocketAllMiniTickersClient(callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketAllTickersClient() {
        val callback: TestCallback<Ticker> = TestCallback()
        val client = WebsocketAllTickersClient(callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketBookTickerClient() {
        val callback = TestCallback<BookTicker>()
        val client = WebsocketBookTickerClient(symbol, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketCandlestickClient() {
        val callback = TestCallback<Candle>()
        val client = WebsocketCandlestickClient(symbol, CandlestickInterval.ONE_MINUTE, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketDepthClient() {
        val callback = TestCallback<Depth>()
        val client = WebsocketDepthClient(symbol, DepthUpdateSpeed.MS_100, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketMiniDepthClient() {
        val callback = TestCallback<MiniDepth>()
        val client = WebsocketMiniDepthClient(symbol, DepthLevel.LEVEL_5, DepthUpdateSpeed.MS_100, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketMiniTickerClient() {
        val callback = TestCallback<MiniTicker>()
        val client = WebsocketMiniTickerClient(symbol, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketTickerClient() {
        val callback = TestCallback<Ticker>()
        val client = WebsocketTickerClient(symbol, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    @Test
    fun testWebsocketTradeClient() {
        val callback = TestCallback<Trade>()
        val client = WebsocketTradeClient(symbol, callback)
        callback.websocketClient = client
        client.open()
        callback.future.get()
    }

    //@Test
    //fun testWebsocketUserDataClient() {
    //    val callback = TestCallback<UserDataUpdate>() // @Test
    //    val client = WebsocketUserDataClient(Connectors.rest(key, secret).user, callback)
    //    callback.websocketClient = client
    //    client.open()
    //    callback.future.get()
    //}


    /**
     * Event handler callback.
     */
    private class TestCallback<T> : WebsocketCallback<T> {
        var future: CompletableFuture<Void?> = CompletableFuture()
        var websocketClient: BaseWebsocketClient<T>? = null

        override fun onMessage(message: T) {
            println(message)
            Assertions.assertNotNull(message)
            websocketClient?.close()
        }

        override fun onOpen(response: Response) {
            println(response)
            Assertions.assertNotNull(response)
        }

        override fun onFailure(exception: ApiException) {
            println(exception)
            Assertions.assertNotNull(exception)
            websocketClient?.close()
            future.complete(null)
        }

        override fun onClosing(websocketCloseObject: WebsocketCloseObject) {
            println(websocketCloseObject)
            Assertions.assertNotNull(websocketCloseObject)
        }

        override fun onClosed(websocketCloseObject: WebsocketCloseObject) {
            println(websocketCloseObject)
            Assertions.assertNotNull(websocketCloseObject)
            future.complete(null)
        }
    }
}