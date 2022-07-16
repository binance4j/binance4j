package com.binance4j.strategy.service;

import java.util.List;

import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.strategy.TradingStrategy;

/**
 * A service to get the position of a {@link TradingStrategy} over a
 * {@link BarSeries} or a {@link CandlestickInterval}
 */
public class PositionService {
    private PositionService() {
    }

    /**
     * Tells if the strategy sends a BUY signal on the selected bar of the given
     * {@link BarSeries}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param series   The {@link BarSeries} to analyze
     * @param index    The {@link Bar} to analyze
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldEnter(TradingStrategy strategy, BarSeries series, int index) {
        return StrategyBuilder.build(strategy, series).shouldEnter(index);
    }

    /**
     * Tells if the strategy sends a BUY signal on the last bar of the given
     * {@link BarSeries}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param series   The {@link BarSeries} to analyze
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldEnter(TradingStrategy strategy, BarSeries series) {
        return shouldEnter(strategy, series, series.getBarCount() - 1);
    }

    /**
     * Tells if the strategy sends a SELL signal on the selected bar of the given
     * {@link BarSeries}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param series   The {@link BarSeries} to analyze
     * @param index    The {@link Bar} to analyze
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldExit(TradingStrategy strategy, BarSeries series, int index) {
        return StrategyBuilder.build(strategy, series).shouldExit(index);
    }

    /**
     * Tells if the strategy sends a SELL signal on the last bar of the given
     * {@link BarSeries}
     *
     * @param strategy The {@link TradingStrategy} to analyze
     * @param series   The {@link BarSeries} to analyze
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldExit(TradingStrategy strategy, BarSeries series) {
        return shouldExit(strategy, series, series.getBarCount() - 1);
    }

    // CandlestickBars

    /**
     * Tells if the strategy sends a BUY signal on the selected bar of the given
     * {@link CandlestickInterval}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param bars     The {@link Candle CandlestickBars} to analyze
     * @param interval The interval between every bar
     * @param index    The {@link Bar} to analyze
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldEnter(TradingStrategy strategy, List<Candle> bars, CandlestickInterval interval,
            int index) {
        return shouldEnter(strategy, BarSeriesService.convert(bars, interval), index);
    }

    /**
     * Tells if the strategy sends a BUY signal on the selected bar of the given
     * {@link CandlestickInterval}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param bars     The {@link Candle CandlestickBars} to analyze
     * @param interval The interval between every bar
     * @return If the strategy sends a BUY signal
     */
    public static boolean shouldEnter(TradingStrategy strategy, List<Candle> bars, CandlestickInterval interval) {
        return shouldEnter(strategy, BarSeriesService.convert(bars, interval));
    }

    /**
     * Tells if the strategy sends a SELL signal on the selected bar of the given
     * {@link CandlestickInterval}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param bars     The {@link Candle CandlestickBars} to analyze
     * @param interval The interval between every bar
     * @param index    The {@link Bar} to analyze
     * @return If the strategy sends a SELL signal
     */
    public static boolean shouldExit(TradingStrategy strategy, List<Candle> bars, CandlestickInterval interval,
            int index) {
        return shouldExit(strategy, BarSeriesService.convert(bars, interval), index);
    }

    /**
     * Tells if the strategy sends a SELL signal on the selected bar of the given
     * {@link CandlestickInterval}
     * 
     * @param strategy The {@link TradingStrategy} to analyze
     * @param bars     The {@link Candle CandlestickBars} to analyze
     * @param interval The interval between every bar
     * @return If the strategy sends a SELL signal
     */
    public static boolean shouldExit(TradingStrategy strategy, List<Candle> bars, CandlestickInterval interval) {
        return shouldExit(strategy, BarSeriesService.convert(bars, interval));
    }

}
