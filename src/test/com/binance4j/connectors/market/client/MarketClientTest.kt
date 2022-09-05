package com.binance4j.connectors.market.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.dto.CandlestickInterval
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Test

internal class MarketClientTest : CustomTest() {

    private var client = Connectors.rest(key, secret).market

    @Test
    fun `Ping server`() = assertDoesNotThrow(client.ping())

    @Test
    fun `Get server time`() = assertDoesNotThrow(client.getServerTime())

    @Test
    fun `Get exchange info for all symbols`() = assertDoesNotThrow(client.getExchangeInfo())

    @Test
    fun `Get exchange info for one symbol`() = assertDoesNotThrow(client.getExchangeInfo(symbol))

    @Test
    fun `Get exchange info for specific symbols`() = assertDoesNotThrow(client.getExchangeInfo(symbols))

    @Test
    fun `Get symbol depth`() = assertDoesNotThrow(client.getOrderBook(symbol))

    @Test
    fun `Get trades for a symbol`() = assertDoesNotThrow(client.getTrades(symbol))

    @Test
    fun `Get trades for a symbol with a limit`() = assertDoesNotThrow(client.getTrades(symbol, limit))

    @Test
    fun `Get historical trades`() = assertDoesNotThrow(client.getHistoricalTrades(symbol))

    @Test
    fun `Get historical trades with a limit`() = assertDoesNotThrow(client.getHistoricalTrades(symbol, limit))

    @Test
    fun `Get agg trades for a symbol`() = assertDoesNotThrow(client.getAggTrades(symbol))

    @Test
    fun `Get agg trades for a symbol in an interval`() = assertDoesNotThrow(client.getAggTrades(symbol, null, lastHour, today, limit))

    @Test
    fun `Get klines for a symbol`() = assertDoesNotThrow(client.getKlines(symbol, CandlestickInterval.ONE_MINUTE))

    @Test
    fun `Get klines for a symbol on an interval`() = assertDoesNotThrow(client.getKlines(symbol, CandlestickInterval.ONE_MINUTE, lastYear, today, limit))

    @Test
    fun `Get average price`() = assertDoesNotThrow(client.getAveragePrice(symbol))

    @Test
    fun `Get 24h ticker for a symbol`() = assertDoesNotThrow(client.get24hTicker(symbol))

    @Test
    fun `Get 24h ticker for multiple symbols`() = assertDoesNotThrow(client.get24hTicker(symbols))

    @Test
    fun `Get 24h ticker for all symbols`() = assertDoesNotThrow(client.get24hTicker())

    @Test
    fun `Get ticker for one symbol`() = assertDoesNotThrow(client.getTicker(symbol))

    @Test
    fun `Get ticker for multiple symbols`() = assertDoesNotThrow(client.getTicker(symbols))

    @Test
    fun `Get ticker for all symbols`() = assertDoesNotThrow(client.getTicker())

    @Test
    fun `Get book ticker for one symbol`() = assertDoesNotThrow(client.getBookTicker(symbol))

    @Test
    fun `Get book ticker for multiple symbols`() = assertDoesNotThrow(client.getBookTicker(symbols))

    @Test
    fun `Get book ticker for all symbols`() = assertDoesNotThrow(client.getBookTicker())
}