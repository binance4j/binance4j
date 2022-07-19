package com.binance4j.strategy.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DecimalNum;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.service.DurationService;

/** A service for manipulating {@link Bar Bars}. */
public class BarService {
	/** Constructor */
	private BarService() {
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar        The {@link Candle}.
	 * @param timePeriod The interval between two candles.
	 * @param zoneId     The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(Candle bar, Duration timePeriod, ZoneId zoneId) {
		return BaseBar.builder(DecimalNum::valueOf, BigDecimal.class).timePeriod(timePeriod)
				.endTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(bar.closeTime()), zoneId)).openPrice(bar.open()).highPrice(bar.high()).lowPrice(bar.low())
				.closePrice(bar.close()).volume(bar.volume()).build();
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default {@link ZoneId}
	 *
	 * @param bar        The {@link Candle}.
	 * @param timePeriod The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(Candle bar, Duration timePeriod) {
		return convert(bar, timePeriod, ZoneId.systemDefault());
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar      The candle.
	 * @param interval The interval between two candles.
	 * @param zoneId   The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(Candle bar, CandlestickInterval interval, ZoneId zoneId) {
		return convert(bar, DurationService.convert(interval), zoneId);
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default {@link ZoneId}
	 *
	 * @param bar      The candle.
	 * @param interval The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(Candle bar, CandlestickInterval interval) {
		return convert(bar, interval, ZoneId.systemDefault());
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar        The {@link Candle}.
	 * @param timePeriod The interval between two candles.
	 * @param zoneId     The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(CandlePayload bar, Duration timePeriod, ZoneId zoneId) {
		return BaseBar.builder(DecimalNum::valueOf, BigDecimal.class).timePeriod(timePeriod)
				.endTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(bar.closeTime()), zoneId)).openPrice(bar.open()).highPrice(bar.high()).lowPrice(bar.low())
				.closePrice(bar.close()).volume(bar.volume()).build();
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default {@link ZoneId}
	 *
	 * @param bar        The {@link Candle}.
	 * @param timePeriod The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(CandlePayload bar, Duration timePeriod) {
		return convert(bar, timePeriod, ZoneId.systemDefault());
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar      The candle.
	 * @param interval The interval between two candles.
	 * @param zoneId   The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(CandlePayload bar, CandlestickInterval interval, ZoneId zoneId) {
		return convert(bar, DurationService.convert(interval), zoneId);
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default {@link ZoneId}
	 *
	 * @param bar      The candle.
	 * @param interval The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static Bar convert(CandlePayload bar, CandlestickInterval interval) {
		return convert(bar, interval, ZoneId.systemDefault());
	}
}
