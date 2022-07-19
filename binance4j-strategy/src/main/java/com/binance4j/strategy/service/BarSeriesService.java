package com.binance4j.strategy.service;

import java.time.Duration;
import java.time.ZoneId;
import java.util.List;

import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.websocket.service.DurationService;

/** A service for manipulating {@link BarSeries} */
public class BarSeriesService {

	/** The default bar series name. */
	private static String defaultBarSeriesName = "Bar series";

	/** Constructor */
	private BarSeriesService() {
	}

	// With Duration

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries}
	 *
	 * @param bars       The candles.
	 * @param timePeriod The interval between two candles.
	 * @param name       The {@link BarSeries} name.
	 * @param zoneId     The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, Duration timePeriod, String name, ZoneId zoneId) {
		BarSeries series = new BaseBarSeriesBuilder().withName(name).build();

		bars.forEach(bar -> series.addBar(BarService.convert(bar, timePeriod, zoneId)));

		return series;
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default system {@link ZoneId}
	 *
	 * @param bars       The candles.
	 * @param timePeriod The interval between two candles.
	 * @param name       The {@link BarSeries} name.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, Duration timePeriod, String name) {
		return convert(bars, timePeriod, name, ZoneId.systemDefault());
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default name
	 *
	 * @param bars       The candles.
	 * @param timePeriod The interval between two candles.
	 * @param zoneId     The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, Duration timePeriod, ZoneId zoneId) {
		return convert(bars, timePeriod, defaultBarSeriesName, zoneId);
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default name and system {@link ZoneId}
	 *
	 * @param bars       The candles.
	 * @param timePeriod The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, Duration timePeriod) {
		return convert(bars, timePeriod, defaultBarSeriesName, ZoneId.systemDefault());
	}

	// With CandlestickInterval

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries}
	 *
	 * @param bars     The candles.
	 * @param interval The interval between two candles.
	 * @param name     The {@link BarSeries} name.
	 * @param zoneId   The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, CandlestickInterval interval, String name, ZoneId zoneId) {
		return convert(bars, DurationService.convert(interval), name, zoneId);
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default system {@link ZoneId}
	 *
	 * @param bars     The candles.
	 * @param interval The interval between two candles.
	 * @param name     The {@link BarSeries} name.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, CandlestickInterval interval, String name) {
		return convert(bars, DurationService.convert(interval), name);
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default name
	 *
	 * @param bars     The candles.
	 * @param interval The interval between two candles.
	 * @param zoneId   The end time {@link ZoneId}.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, CandlestickInterval interval, ZoneId zoneId) {
		return convert(bars, DurationService.convert(interval), zoneId);
	}

	/**
	 * Converts a list of {@link Candle}s into a {@link BarSeries} with default name and system {@link ZoneId}
	 *
	 * @param bars     The candles.
	 * @param interval The interval between two candles.
	 * @return The generated {@link BarSeries}.
	 */
	public static BarSeries convert(List<Candle> bars, CandlestickInterval interval) {
		return convert(bars, DurationService.convert(interval));
	}

	/**
	 * @return the defaultBarSeriesName
	 */
	public static String getDefaultBarSeriesName() {
		return defaultBarSeriesName;
	}

	/**
	 * @param defaultBarSeriesName the defaultBarSeriesName to set
	 */
	public static void setDefaultBarSeriesName(String defaultBarSeriesName) {
		BarSeriesService.defaultBarSeriesName = defaultBarSeriesName;
	}
}