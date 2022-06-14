package com.binance4j.strategy.service;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.websocket.service.DurationService;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.num.DecimalNum;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * A service for manipulating {@link Bar Bars}
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BarService {

    /**
     * Converts a {@link CandlestickBar}s into a {@link Bar}
     * 
     * @param bar        The {@link CandlestickBar}
     * @param timePeriod The interval between two candles
     * @param zoneId     The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static Bar convert(CandlestickBar bar, Duration timePeriod, ZoneId zoneId) {
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
     * Converts a {@link CandlestickBar}s into a {@link Bar} with default
     * {@link ZoneId}
     * 
     * @param bar        The {@link CandlestickBar}
     * @param timePeriod The interval between two candles
     * @return The generated {@link BarSeries}
     */
    public static Bar convert(CandlestickBar bar, Duration timePeriod) {
        return convert(bar, timePeriod, ZoneId.systemDefault());
    }

    /**
     * Converts a {@link CandlestickBar}s into a {@link Bar}
     * 
     * @param bar      The Candlestick bar
     * @param interval The interval between two candles
     * @param zoneId   The end time {@link ZoneId}
     * @return The generated {@link BarSeries}
     */
    public static Bar convert(CandlestickBar bar, CandlestickInterval interval, ZoneId zoneId) {
        return convert(bar, DurationService.convert(interval), zoneId);
    }

    /**
     * Converts a {@link CandlestickBar}s into a {@link Bar} with default
     * {@link ZoneId}
     * 
     * @param bar      The Candlestick bar
     * @param interval The interval between two candles
     * @return The generated {@link BarSeries}
     */
    public static Bar convert(CandlestickBar bar, CandlestickInterval interval) {
        return convert(bar, interval, ZoneId.systemDefault());
    }
}
