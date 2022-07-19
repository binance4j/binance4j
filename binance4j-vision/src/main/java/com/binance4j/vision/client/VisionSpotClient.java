package com.binance4j.vision.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.vision.dto.VisionTrade;
import com.binance4j.vision.request.AggTradeRequest;
import com.binance4j.vision.request.CandlestickRequest;
import com.binance4j.vision.request.ChecksumRequest;
import com.binance4j.vision.request.TradeRequest;
import com.binance4j.vision.request.VisionRequest;

import retrofit2.Retrofit;

/**
 * The client for retrieving the SPOT public data (trades, aggTrades and klines)
 * 
 * @see <a href="https://data.binance.vision/">Documentation</a>
 */
public class VisionSpotClient {
	private final VisionSpotMapping service;

	public VisionSpotClient() {
		service = new Retrofit.Builder().baseUrl("https://data.binance.vision/data/").build().create(VisionSpotMapping.class);
	}

	/**
	 * Get the compressed csv containing the candlestick data for a symbol (monthly)
	 *
	 * @param symbol              The trading pair.
	 * @param candlestickInterval The interval.
	 * @param year                The year.
	 * @param month               The month.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<Candle> getKlines(String symbol, CandlestickInterval candlestickInterval, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new CandlestickRequest(service.getMonthlyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol              The trading pair.
	 * @param candlestickInterval The interval.
	 * @param year                The year.
	 * @param month               The month.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getKlinesChecksum(String symbol, CandlestickInterval candlestickInterval, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getMonthlyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(), year, month));
	}

	/**
	 * Get the compressed csv containing the candlestick data for a symbol (daily)
	 *
	 * @param symbol              The trading pair.
	 * @param candlestickInterval The interval.
	 * @param year                The year.
	 * @param month               The month.
	 * @param day                 The day.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<Candle> getKlines(String symbol, CandlestickInterval candlestickInterval, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new CandlestickRequest(service.getDailyKlines(symbol.toUpperCase(), candlestickInterval.getValue(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol              The trading pair.
	 * @param candlestickInterval The interval.
	 * @param year                The year.
	 * @param month               The month.
	 * @param day                 The day.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getKlinesChecksum(String symbol, CandlestickInterval candlestickInterval, String year, String month, String day)
			throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getDailyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.getValue(), year, month, day));
	}

	// Trades

	/**
	 * Get the compressed csv containing the trades data for a symbol (monthly)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<VisionTrade> getTrades(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new TradeRequest(service.getMonthlyTrades(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getTradesChecksum(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getMonthlyTradesChecksum(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the compressed csv containing the trades data for a symbol (daily)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<VisionTrade> getTrades(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new TradeRequest(service.getDailyTrades(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getTradesChecksum(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getDailyTradesChecksum(symbol.toUpperCase(), year, month, day));
	}

	// AggTrades

	/**
	 * Get the compressed csv containing the aggTrades data for a symbol (monthly)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<AggTrade> getAggTrades(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new AggTradeRequest(service.getMonthlyAggTrades(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getAggTradesChecksum(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getMonthlyAggTradesChecksum(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the compressed csv containing the aggTrades data for a symbol (daily)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @return The zip file containing the data.
	 */
	public VisionRequest<AggTrade> getAggTrades(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new AggTradeRequest(service.getDailyAggTrades(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol The trading pair.
	 * @param year   The year.
	 * @param month  The month.
	 * @param day    The day.
	 * @return The zip file containing the data.
	 */
	public ChecksumRequest getAggTradesChecksum(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumRequest(service.getDailyAggTradesChecksum(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Checks if the given date is valid
	 *
	 * @param year  The year.
	 * @param month The month.
	 * @param day   The day.
	 * @return if the date exists.
	 */
	private boolean isValidDate(String year, String month, String day) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			format.setLenient(false);
			format.parse(String.format("%s/%s/%s", month, day, year));
			return true;
		} catch (ParseException | IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Checks if the given date is valid
	 *
	 * @param year  The year.
	 * @param month The month.
	 * @return if the date exists.
	 */
	private boolean isValidDate(String year, String month) {
		return isValidDate(year, month, "01");
	}
}
