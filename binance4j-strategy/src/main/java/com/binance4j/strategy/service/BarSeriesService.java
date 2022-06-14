package com.binance4j.strategy.service;

import java.time.Duration;
import java.time.ZoneId;
import java.util.List;

import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.service.DurationService;

import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBarSeriesBuilder;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A service for manipulating {@link BarSeries}
 */
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BarSeriesService {

    /**
     * The default bar series name
     */
    @Getter
    @Setter
    private static String defaultBarSeriesName = "Bar series";

    // With Duration

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries}
     * 
     * @param bars       The candlestick bars
     * @param timePeriod The interval between two candles
     * @param name       The {@link BarSeries} name
     * @param zoneId     The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, Duration timePeriod, String name,
            ZoneId zoneId) {
        BarSeries series = new BaseBarSeriesBuilder().withName(name).build();

        bars.forEach(bar -> series.addBar(BarService.convert(bar, timePeriod, zoneId)));

        return series;
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default system {@link ZoneId}
     * 
     * @param bars       The candlestick bars
     * @param timePeriod The interval between two candles
     * @param name       The {@link BarSeries} name
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, Duration timePeriod, String name) {
        return convert(bars, timePeriod, name, ZoneId.systemDefault());
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default name
     * 
     * @param bars       The candlestick bars
     * @param timePeriod The interval between two candles
     * @param zoneId     The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, Duration timePeriod, ZoneId zoneId) {
        return convert(bars, timePeriod, defaultBarSeriesName, zoneId);
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default name and system {@link ZoneId}
     * 
     * @param bars       The candlestick bars
     * @param timePeriod The interval between two candles
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, Duration timePeriod) {
        return convert(bars, timePeriod, defaultBarSeriesName, ZoneId.systemDefault());
    }

    // With CandlestickInterval

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries}
     * 
     * @param bars     The candlestick bars
     * @param interval The interval between two candles
     * @param name     The {@link BarSeries} name
     * @param zoneId   The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, CandlestickInterval interval, String name,
            ZoneId zoneId) {
        return convert(bars, DurationService.convert(interval), name, zoneId);
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default system {@link ZoneId}
     * 
     * @param bars     The candlestick bars
     * @param interval The interval between two candles
     * @param name     The {@link BarSeries} name
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, CandlestickInterval interval, String name) {
        return convert(bars, DurationService.convert(interval), name);
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default name
     * 
     * @param bars     The candlestick bars
     * @param interval The interval between two candles
     * @param zoneId   The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, CandlestickInterval interval, ZoneId zoneId) {
        return convert(bars, DurationService.convert(interval), zoneId);
    }

    /**
     * Converts a list of {@link CandlestickBar}s into a {@link BarSeries} with
     * default name and system {@link ZoneId}
     * 
     * @param bars     The candlestick bars
     * @param interval The interval between two candles
     * @return The generated {@link BarSeries}
     */
    public static BarSeries convert(List<CandlestickBar> bars, CandlestickInterval interval) {
        return convert(bars, DurationService.convert(interval));
    }
}
