package com.binance4j.vision.client;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.binance4j.core.dto.AggTrade;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.vision.dto.VisionTrade;
import com.binance4j.vision.param.AggTradeParams;
import com.binance4j.vision.param.CandlestickParams;
import com.binance4j.vision.param.ChecksumParams;
import com.binance4j.vision.param.TradeParams;
import com.binance4j.vision.param.VisionParams;

import retrofit2.Retrofit;

/**
 * The client for retrieving the SPOT public data (trades, aggTrades and klines)
 * 
 * @see <a href="https://data.binance.vision/">Documentation</a>
 */
public class VisionSpotClient {
	/** Client service. */
	final VisionSpotMapping service;

	/** Constructor */
	public VisionSpotClient() {
		service = new Retrofit.Builder().baseUrl("https://data.binance.vision/data/").build().create(VisionSpotMapping.class);
	}

	/**
	 * Get the compressed csv containing the candlestick data for a symbol (monthly)
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The zip file containing the data.
	 * @throws InvalidDateException Given date is invalid.
	 */
	public VisionParams<Candle> getKlines(String symbol, CandlestickInterval candlestickInterval, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new CandlestickParams(service.getMonthlyKlines(symbol.toUpperCase(), candlestickInterval.toString(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval.
	 * @param year                Year.
	 * @param month               Month.
	 * @return The zip file containing the data.
	 * @throws InvalidDateException Given date is invalid.
	 */
	public ChecksumParams getKlinesChecksum(String symbol, CandlestickInterval candlestickInterval, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumParams(service.getMonthlyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.toString(), year, month));
	}

	/**
	 * Get the compressed csv containing the candlestick data for a symbol (daily)
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The zip file containing the data.
	 * @throws InvalidDateException Given date is invalid.
	 */
	public VisionParams<Candle> getKlines(String symbol, CandlestickInterval candlestickInterval, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new CandlestickParams(service.getDailyKlines(symbol.toUpperCase(), candlestickInterval.toString(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol              Trading pair.
	 * @param candlestickInterval Interval.
	 * @param year                Year.
	 * @param month               Month.
	 * @param day                 Day.
	 * @return The zip file containing the data.
	 * @throws InvalidDateException Given date is invalid.
	 */
	public ChecksumParams getKlinesChecksum(String symbol, CandlestickInterval candlestickInterval, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumParams(service.getDailyKlinesChecksum(symbol.toUpperCase(), candlestickInterval.toString(), year, month, day));
	}

	// Trades

	/**
	 * Get the compressed csv containing the trades data for a symbol (monthly)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public VisionParams<VisionTrade> getTrades(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new TradeParams(service.getMonthlyTrades(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public ChecksumParams getTradesChecksum(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumParams(service.getMonthlyTradesChecksum(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the compressed csv containing the trades data for a symbol (daily)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public VisionParams<VisionTrade> getTrades(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new TradeParams(service.getDailyTrades(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public ChecksumParams getTradesChecksum(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumParams(service.getDailyTradesChecksum(symbol.toUpperCase(), year, month, day));
	}

	// AggTrades

	/**
	 * Get the compressed csv containing the aggTrades data for a symbol (monthly)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public VisionParams<AggTrade> getAggTrades(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new AggTradeParams(service.getMonthlyAggTrades(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the checksum of the zip archive (monthly)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public ChecksumParams getAggTradesChecksum(String symbol, String year, String month) throws ApiException {
		if (!isValidDate(year, month))
			throw new InvalidDateException();

		return new ChecksumParams(service.getMonthlyAggTradesChecksum(symbol.toUpperCase(), year, month));
	}

	/**
	 * Get the compressed csv containing the aggTrades data for a symbol (daily)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public VisionParams<AggTrade> getAggTrades(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new AggTradeParams(service.getDailyAggTrades(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Get the checksum of the zip archive (daily)
	 *
	 * @param symbol Trading pair.
	 * @param year   Year.
	 * @param month  Month.
	 * @param day    Day.
	 * @return The zip file containing the data.
	 * @throws ApiException Thrown when the fetching failed
	 */
	public ChecksumParams getAggTradesChecksum(String symbol, String year, String month, String day) throws ApiException {
		if (!isValidDate(year, month, day))
			throw new InvalidDateException();

		return new ChecksumParams(service.getDailyAggTradesChecksum(symbol.toUpperCase(), year, month, day));
	}

	/**
	 * Checks if the given date is valid
	 *
	 * @param year  Year.
	 * @param month Month.
	 * @param day   Day.
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
	 * @param year  Year.
	 * @param month Month.
	 * @return if the date exists.
	 */
	private boolean isValidDate(String year, String month) {
		return isValidDate(year, month, "01");
	}
}
