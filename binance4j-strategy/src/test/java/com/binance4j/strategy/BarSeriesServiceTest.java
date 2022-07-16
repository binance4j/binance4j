package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.service.BarSeriesService;
import com.binance4j.vision.client.VisionSpotClient;

/** TODO JAVADOC */
public class BarSeriesServiceTest extends ConcurrentTest<VisionSpotClient> {
	List<Candle> bars;

	public BarSeriesServiceTest() throws ApiException {
		super(new VisionSpotClient());
		// Let's get some public data
		bars = client.getKlines("BTCBUSD", CandlestickInterval.FIVE_MINUTES, "2022", "01").getData();
	}

	@Test
	public void checkDefaultNameEquality() {
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5));
		assertEquals(series.getName(), BarSeriesService.getDefaultBarSeriesName());
	}

	@Test
	void convertWIthCustomName() {
		String barName = " test";
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5), barName);
		assertEquals(series.getName(), barName);
	}

	@Test
	public void convertWithDefaults() {
		BarSeries series = BarSeriesService.convert(bars, Duration.ofMinutes(5));
		makeAssertion(bars, series);
	}

	/**
	 * Compares input and output equality
	 *
	 * @param bars   the candles
	 * @param series the converted bars
	 */
	void makeAssertion(List<Candle> bars, BarSeries series) {
		for (int i = 0; i < series.getBarCount(); i++) {
			Bar bar1 = series.getBar(i);
			Candle bar2 = bars.get(i);
			Long closeTime = Timestamp.valueOf(bar1.getEndTime().toLocalDateTime()).getTime();
			long openTime = Timestamp.valueOf(bar1.getBeginTime().toLocalDateTime()).getTime();

			assertEquals(closeTime, bar2.getCloseTime());
			// There is a 1 millisecond diff between the two bars
			assertEquals(openTime + 1, bar2.getOpenTime());
			assertEquals(new BigDecimal(bar1.getOpenPrice().toString()), bar2.getOpen());
			assertEquals(new BigDecimal(bar1.getHighPrice().toString()), bar2.getHigh());
			assertEquals(new BigDecimal(bar1.getLowPrice().toString()), bar2.getLow());
			assertEquals(new BigDecimal(bar1.getClosePrice().toString()), bar2.getClose());
			assertEquals(new BigDecimal(bar1.getVolume().toString()), bar2.getVolume());

			test(bar2);
		}
	}
}