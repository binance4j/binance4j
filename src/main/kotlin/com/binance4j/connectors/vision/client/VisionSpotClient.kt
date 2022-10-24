/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.connectors.vision.client

import com.binance4j.connectors.core.dto.AggTrade
import com.binance4j.connectors.core.dto.Candle
import com.binance4j.connectors.core.dto.CandlestickInterval
import com.binance4j.connectors.core.exception.ApiException
import com.binance4j.connectors.core.exception.InvalidDateException
import com.binance4j.connectors.vision.dto.VisionTrade
import com.binance4j.connectors.vision.param.*
import retrofit2.Retrofit
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * The client for retrieving the SPOT public data (trades, aggTrades and klines)
 *
 * [Documentation](https://data.binance.vision/)
 */
object VisionSpotClient {
    /** Client service. */
    val service: VisionSpotMapping = Retrofit.Builder().baseUrl("https://data.binance.vision/data/").build()
        .create(VisionSpotMapping::class.java)

    /**
     * Get the compressed csv containing the candlestick data for a symbol (monthly)
     *
     * @param symbol              Trading pair.
     * @param candlestickInterval Interval.
     * @param year                Year.
     * @param month               Month.
     *
     * @return The zip file containing the data.
     *
     * @throws InvalidDateException Given date is invalid.
     */
    @Throws(ApiException::class)
    fun getKlines(
        symbol: String, candlestickInterval: CandlestickInterval, year: String,
        month: String
    ): VisionParams<Candle> {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return CandlestickParams(
            service.getMonthlyKlines(symbol.uppercase(Locale.getDefault()), candlestickInterval.toString(), year, month)
        )
    }

    /**
     * Get the checksum of the zip archive (monthly)
     *
     * @param symbol              Trading pair.
     * @param candlestickInterval Interval.
     * @param year                Year.
     * @param month               Month.
     *
     * @return The zip file containing the data.
     *
     * @throws InvalidDateException Given date is invalid.
     */
    @Throws(ApiException::class)
    fun getKlinesChecksum(
        symbol: String, candlestickInterval: CandlestickInterval, year: String,
        month: String
    ): ChecksumParams {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return ChecksumParams(
            service.getMonthlyKlinesChecksum(
                symbol.uppercase(Locale.getDefault()),
                candlestickInterval.toString(),
                year,
                month
            )
        )
    }

    /**
     * Get the compressed csv containing the candlestick data for a symbol (daily)
     *
     * @param symbol              Trading pair.
     * @param candlestickInterval Interval.
     * @param year                Year.
     * @param month               Month.
     * @param day                 Day.
     *
     * @return The zip file containing the data.
     *
     * @throws InvalidDateException Given date is invalid.
     */
    @Throws(ApiException::class)
    fun getKlines(
        symbol: String, candlestickInterval: CandlestickInterval, year: String,
        month: String, day: String
    ): VisionParams<Candle> {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return CandlestickParams(
            service.getDailyKlines(
                symbol.uppercase(Locale.getDefault()),
                candlestickInterval.toString(),
                year,
                month,
                day
            )
        )
    }

    /**
     * Get the checksum of the zip archive (daily)
     *
     * @param symbol              Trading pair.
     * @param candlestickInterval Interval.
     * @param year                Year.
     * @param month               Month.
     * @param day                 Day.
     *
     * @return The zip file containing the data.
     *
     * @throws InvalidDateException Given date is invalid.
     */
    @Throws(ApiException::class)
    fun getKlinesChecksum(
        symbol: String, candlestickInterval: CandlestickInterval, year: String,
        month: String, day: String
    ): ChecksumParams {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return ChecksumParams(
            service.getDailyKlinesChecksum(
                symbol.uppercase(Locale.getDefault()),
                candlestickInterval.toString(),
                year,
                month,
                day
            )
        )
    }
    // Trades
    /**
     * Get the compressed csv containing the trades data for a symbol (monthly)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getTrades(symbol: String, year: String, month: String): VisionParams<VisionTrade> {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return TradeParams(service.getMonthlyTrades(symbol.uppercase(Locale.getDefault()), year, month))
    }

    /**
     * Get the checksum of the zip archive (monthly)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getTradesChecksum(symbol: String, year: String, month: String): ChecksumParams {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return ChecksumParams(service.getMonthlyTradesChecksum(symbol.uppercase(Locale.getDefault()), year, month))
    }

    /**
     * Get the compressed csv containing the trades data for a symbol (daily)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     * @param day    Day.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getTrades(symbol: String, year: String, month: String, day: String): VisionParams<VisionTrade> {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return TradeParams(service.getDailyTrades(symbol.uppercase(Locale.getDefault()), year, month, day))
    }

    /**
     * Get the checksum of the zip archive (daily)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     * @param day    Day.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getTradesChecksum(symbol: String, year: String, month: String, day: String): ChecksumParams {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return ChecksumParams(service.getDailyTradesChecksum(symbol.uppercase(Locale.getDefault()), year, month, day))
    }
    // AggTrades
    /**
     * Get the compressed csv containing the aggTrades data for a symbol (monthly)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getAggTrades(symbol: String, year: String, month: String): VisionParams<AggTrade> {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return AggTradeParams(service.getMonthlyAggTrades(symbol.uppercase(Locale.getDefault()), year, month))
    }

    /**
     * Get the checksum of the zip archive (monthly)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getAggTradesChecksum(symbol: String, year: String, month: String): ChecksumParams {
        if (!isValidDate(year, month)) throw InvalidDateException()
        return ChecksumParams(service.getMonthlyAggTradesChecksum(symbol.uppercase(Locale.getDefault()), year, month))
    }

    /**
     * Get the compressed csv containing the aggTrades data for a symbol (daily)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     * @param day    Day.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getAggTrades(symbol: String, year: String, month: String, day: String): VisionParams<AggTrade> {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return AggTradeParams(service.getDailyAggTrades(symbol.uppercase(Locale.getDefault()), year, month, day))
    }

    /**
     * Get the checksum of the zip archive (daily)
     *
     * @param symbol Trading pair.
     * @param year   Year.
     * @param month  Month.
     * @param day    Day.
     *
     * @return The zip file containing the data.
     *
     * @throws ApiException Thrown when the fetching failed
     */
    @Throws(ApiException::class)
    fun getAggTradesChecksum(symbol: String, year: String, month: String, day: String): ChecksumParams {
        if (!isValidDate(year, month, day)) throw InvalidDateException()
        return ChecksumParams(
            service.getDailyAggTradesChecksum(
                symbol.uppercase(Locale.getDefault()),
                year,
                month,
                day
            )
        )
    }

    /**
     * Checks if the given date is valid
     *
     * @param year  Year.
     * @param month Month.
     * @param day   Day.
     *
     * @return if the date exists.
     */
    private fun isValidDate(year: String, month: String, day: String): Boolean {
        return try {
            val format = SimpleDateFormat("MM/dd/yyyy")
            format.isLenient = false
            format.parse(String.format("%s/%s/%s", month, day, year))
            true
        } catch (e: ParseException) {
            false
        } catch (e: IllegalArgumentException) {
            false
        }
    }

    /**
     * Checks if the given date is valid
     *
     * @param year  Year.
     * @param month Month.
     *
     * @return if the date exists.
     */
    private fun isValidDate(year: String, month: String): Boolean {
        return isValidDate(year, month, "01")
    }
}