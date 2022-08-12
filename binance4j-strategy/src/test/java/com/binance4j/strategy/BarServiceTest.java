package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.ta4j.core.Bar;

import com.binance4j.core.client.RestClient;
import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.CustomTest;
import com.binance4j.strategy.service.BarService;

public class BarServiceTest extends CustomTest {
	final Candle candle;

	public BarServiceTest() {
		super();
		String open = "1";
		String high = "2";
		String low = "1";
		String close = "2";
		String volume = "10";
		candle = new Candle(System.currentTimeMillis(), open, high, low, close, volume, System.currentTimeMillis(), "1",
				0L, "1", "1");
	}

	@Test
	void convertWithDuration() {
		Bar bar = BarService.convert(candle, Duration.ofMinutes(5));
		assertValues(bar, candle);
	}

	@Test
	void testConvert2() {
		Bar bar = BarService.convert(candle, CandlestickInterval.FIVE_MINUTES);
		assertValues(bar, candle);
	}

	@Test
	void testConvert3() {
		Bar bar = BarService.convert(candle, CandlestickInterval.FIVE_MINUTES);
		assertValues(bar, candle);
	}

	void assertValues(Bar bar, Candle candle) {
		assertEquals(bar.getOpenPrice().toString(), candle.open());
		assertEquals(bar.getHighPrice().toString(), candle.high());
		assertEquals(bar.getLowPrice().toString(), candle.low());
		assertEquals(bar.getClosePrice().toString(), candle.close());
		assertEquals(bar.getVolume().toString(), candle.volume());
		assertEquals(bar.getEndTime().toInstant().toEpochMilli(), candle.closeTime());
	}

	@Override
	protected RestClient<?> getClient() {
		return null;
	}
}
