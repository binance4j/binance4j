package com.binance4j.connectors.vision.client

import com.binance4j.connectors.connectors.Connectors
import com.binance4j.connectors.core.dto.CandlestickInterval
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.exception.InvalidDateException
import com.binance4j.connectors.core.exception.NotFoundException
import com.binance4j.connectors.core.test.CustomTest
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


internal class VisionSpotClientTest : CustomTest() {
    private val year = "2022"
    private val month = "01"
    private val day = "01"
    private val interval = CandlestickInterval.ONE_MINUTE
    private val client = Connectors.rest.visionSpot

    // AggTrades

    @Test
    fun testInvalidDate() {
        val exception: Exception = assertThrows(ApiException::class.java) { client.getAggTrades(symbol, year, month, "32").getData() }
        assertTrue(exception.message!!.contains(InvalidDateException().message))
    }

    @Test
    fun testNotFoundSync() {
        val exception: Exception = assertThrows(ApiException::class.java) { client.getAggTrades(symbol, "1995", month, day).getData() }
        assertTrue(exception.message!!.contains(NotFoundException().message))
    }

    @Test
    fun testGetAggTrades() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getAggTrades(symbol, year, month, day).getData()) }
    }

    @Test
    fun testGetTrades() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getTrades(symbol, year, month, day).getData()) }
    }

    @Test
    fun testGetKlines() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getKlines(symbol, CandlestickInterval.HOURLY, year, month, day).getData()) }
    }

    // Checksum

    @Test
    fun testKlinesChecksum() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getKlinesChecksum(symbol, interval, year, month, day).getChecksum()) }
    }

    @Test
    fun testTradesChecksum() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getTradesChecksum(symbol, year, month, day).getChecksum()) }
    }

    @Test
    fun testAggTradesChecksum() {
        org.junit.jupiter.api.assertDoesNotThrow { println(client.getAggTradesChecksum(symbol, year, month, day).getChecksum()) }
    }
}