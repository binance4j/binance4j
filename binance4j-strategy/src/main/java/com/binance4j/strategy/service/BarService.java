package com.binance4j.strategy.service;

import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.service.DurationService;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DecimalNum;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * A service for manipulating {@link Bar Bars}
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BarService {

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar        The {@link Candle}
	 * @param timePeriod The interval between two candles
	 * @param zoneId     The end time {@link ZoneId}
	 * @return The generated {@link BarSeries}
	 */
	public static Bar convert(Candle bar, Duration timePeriod, ZoneId zoneId) {
		return BaseBar.builder(DecimalNum::valueOf, BigDecimal.class)
				.timePeriod(timePeriod)
				.endTime(ZonedDateTime.ofInstant(Instant.ofEpochMilli(bar.getCloseTime()), zoneId))
				.openPrice(bar.getOpen())
				.highPrice(bar.getHigh())
				.lowPrice(bar.getLow())
				.closePrice(bar.getClose())
				.volume(bar.getVolume())
				.build();
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default
	 * {@link ZoneId}
	 *
	 * @param bar        The {@link Candle}
	 * @param timePeriod The interval between two candles
	 * @return The generated {@link BarSeries}
	 */
	public static Bar convert(Candle bar, Duration timePeriod) {
		return convert(bar, timePeriod, ZoneId.systemDefault());
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar}
	 *
	 * @param bar      The Candlestick bar
	 * @param interval The interval between two candles
	 * @param zoneId   The end time {@link ZoneId}
	 * @return The generated {@link BarSeries}
	 */
	public static Bar convert(Candle bar, CandlestickInterval interval, ZoneId zoneId) {
		return convert(bar, DurationService.convert(interval), zoneId);
	}

	/**
	 * Converts a {@link Candle}s into a {@link Bar} with default
	 * {@link ZoneId}
	 *
	 * @param bar      The Candlestick bar
	 * @param interval The interval between two candles
	 * @return The generated {@link BarSeries}
	 */
	public static Bar convert(Candle bar, CandlestickInterval interval) {
		return convert(bar, interval, ZoneId.systemDefault());
	}
}
