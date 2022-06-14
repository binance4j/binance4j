package com.binance4j.vision.spot;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.market.AggTrade;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.vision.executor.AggTradeRequestExecutor;
import com.binance4j.vision.executor.CandlestickRequestExecutor;
import com.binance4j.vision.executor.ChecksumRequestExecutor;
import com.binance4j.vision.executor.TradeRequestExecutor;
import com.binance4j.vision.executor.VisionRequestExecutor;

import retrofit2.Retrofit;

/**
 * The client for retrieving the SPOT public data (trades, aggTrades and klines)
 */
public class SpotClient {
    private final SpotMapping service;

    public SpotClient() {
        service = new Retrofit.Builder().baseUrl("https://data.binance.vision/data/").build()
                .create(SpotMapping.class);
    }

    /**
     * Get the compressed csv containing the candlestick data for a
     * symbol (monthly)
     * 
     * @param symbol              The trading pair
     * @param candlestickInterval The interval
     * @param year                The year
     * @param month               The month
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<CandlestickBar> getKlines(String symbol, CandlestickInterval candlestickInterval,
            String year, String month) throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new CandlestickRequestExecutor(
                service.getMonthlyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                        month));
    }

    /**
     * Get the checksum of the zip archive (monthly)
     * 
     * @param symbol              The trading pair
     * @param candlestickInterval The interval
     * @param year                The year
     * @param month               The month
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getKlinesChecksum(String symbol,
            CandlestickInterval candlestickInterval, String year, String month) throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getMonthlyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                        year, month));
    }

    /**
     * Get the compressed csv containing the candlestick data for a
     * symbol (daily)
     * 
     * @param symbol              The trading pair
     * @param candlestickInterval The interval
     * @param year                The year
     * @param month               The month
     * @param day                 The day
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<CandlestickBar> getKlines(String symbol, CandlestickInterval candlestickInterval,
            String year, String month, String day) throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new CandlestickRequestExecutor(
                service.getDailyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year,
                        month, day));
    }

    /**
     * Get the checksum of the zip archive (daily)
     * 
     * @param symbol              The trading pair
     * @param candlestickInterval The interval
     * @param year                The year
     * @param month               The month
     * @param day                 The day
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getKlinesChecksum(String symbol,
            CandlestickInterval candlestickInterval, String year, String month, String day)
            throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getDailyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(),
                        year,
                        month, day));
    }

    // Trades

    /**
     * Get the compressed csv containing the trades data for a
     * symbol (monthly)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<Trade> getTrades(String symbol, String year, String month)
            throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new TradeRequestExecutor(
                service.getMonthlyTrades(symbol.toUpperCase(), year, month));
    }

    /**
     * Get the checksum of the zip archive (monthly)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getTradesChecksum(String symbol, String year, String month)
            throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getMonthlyTradesChecksum(symbol.toUpperCase(), year, month));
    }

    /**
     * Get the compressed csv containing the trades data for a
     * symbol (daily)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @param day    The day
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<Trade> getTrades(String symbol, String year, String month, String day)
            throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new TradeRequestExecutor(
                service.getDailyTrades(symbol.toUpperCase(), year, month, day));
    }

    /**
     * Get the checksum of the zip archive (daily)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @param day    The day
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getTradesChecksum(String symbol, String year, String month,
            String day) throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getDailyTradesChecksum(symbol.toUpperCase(), year, month, day));
    }

    // AggTrades

    /**
     * Get the compressed csv containing the aggTrades data for a
     * symbol (monthly)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<AggTrade> getAggTrades(String symbol, String year, String month)
            throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new AggTradeRequestExecutor(
                service.getMonthlyAggTrades(symbol.toUpperCase(), year, month));
    }

    /**
     * Get the checksum of the zip archive (monthly)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getAggTradesChecksum(String symbol, String year, String month)
            throws ApiException {
        if (!isValidDate(year, month))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getMonthlyAggTradesChecksum(symbol.toUpperCase(), year, month));
    }

    /**
     * Get the compressed csv containing the aggTrades data for a
     * symbol (daily)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @param day    The day
     * @return The zip file containing the data
     */
    public VisionRequestExecutor<AggTrade> getAggTrades(String symbol, String year, String month, String day)
            throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new AggTradeRequestExecutor(
                service.getDailyAggTrades(symbol.toUpperCase(), year, month, day));
    }

    /**
     * Get the checksum of the zip archive (daily)
     * 
     * @param symbol The trading pair
     * @param year   The year
     * @param month  The month
     * @param day    The day
     * @return The zip file containing the data
     */
    public ChecksumRequestExecutor getAggTradesChecksum(String symbol, String year, String month,
            String day) throws ApiException {
        if (!isValidDate(year, month, day))
            throw new InvalidDateException();

        return new ChecksumRequestExecutor(
                service.getDailyAggTradesChecksum(symbol.toUpperCase(), year, month, day));
    }

    /**
     * Checks if the given date is valid
     * 
     * @param year  The year
     * @param month The month
     * @param day   The day
     * @return if the date exists
     */
    private boolean isValidDate(String year, String month, String day) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
            format.setLenient(false);
            format.parse(String.format("%s/%s/%s", month, day, year));
        } catch (ParseException | IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /**
     * Checks if the given date is valid
     * 
     * @param year  The year
     * @param month The month
     * @return if the date exists
     */
    private boolean isValidDate(String year, String month) {
        return isValidDate(year, month, "01");
    }
}
