package com.binance4j.strategy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.market.CandlestickBar;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.vision.spot.SpotClient;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

public class BarSeriesServiceTest {
    SpotClient client;
    List<CandlestickBar> bars;

    public BarSeriesServiceTest() throws IOException, ApiException {
        client = new SpotClient();
        // Let's get some public data
        bars = client.getKlines("BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01").getData();
    }

    @Test
    @DisplayName("The series name should be the default name")
    public void checkDefaulNameEquality() {
        BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5));
        assertEquals(series.getName(), BarSeriesService.getDefaultBarSeriesName());
    }

    @Test
    @DisplayName("The series name should be the given name")
    void convertWIthCustomName() {
        String barName = " test";
        BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5), barName);
        assertEquals(series.getName(), barName);
    }

    @Test
    @DisplayName("The conversion should return the same values in the same order")
    public void convertWithDefaults() {
        BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5));
        makeAssertion(bars, series);
    }

    /**
     * Compares input and output equality
     * 
     * @param bars   the candlestick bars
     * @param series the converted bars
     */
    void makeAssertion(List<CandlestickBar> bars, BarSeries series) {
        for (int i = 0; i < series.getBarCount(); i++) {
            Bar bar1 = series.getBar(i);
            CandlestickBar bar2 = bars.get(i);
            Long closeTime = Timestamp.valueOf(bar1.getEndTime().toLocalDateTime()).getTime();
            Long openTime = Timestamp.valueOf(bar1.getBeginTime().toLocalDateTime()).getTime();

            assertNotNull(closeTime);
            assertNotNull(bar2.getCloseTime());
            assertEquals(closeTime, bar2.getCloseTime());

            assertNotNull(openTime);
            assertNotNull(bar2.getOpenTime());
            // There is a 1 millisecond diff between the two bars
            assertEquals(openTime + 1, bar2.getOpenTime());

            assertNotNull(bar1.getOpenPrice());
            assertNotNull(bar2.getOpen());
            assertEquals(new BigDecimal(bar1.getOpenPrice().toString()), bar2.getOpen());

            assertNotNull(bar1.getHighPrice());
            assertNotNull(bar2.getHigh());
            assertEquals(new BigDecimal(bar1.getHighPrice().toString()), bar2.getHigh());

            assertNotNull(bar1.getLowPrice());
            assertNotNull(bar2.getLow());
            assertEquals(new BigDecimal(bar1.getLowPrice().toString()), bar2.getLow());

            assertNotNull(bar1.getClosePrice());
            assertNotNull(bar2.getClose());
            assertEquals(new BigDecimal(bar1.getClosePrice().toString()), bar2.getClose());

            assertNotNull(bar1.getVolume());
            assertNotNull(bar2.getVolume());
            assertEquals(new BigDecimal(bar1.getVolume().toString()), bar2.getVolume());
        }
    }
}
