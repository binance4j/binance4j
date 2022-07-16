package com.binance4j.strategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.ta4j.core.Bar;

import com.binance4j.core.dto.Candle;
import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.strategy.service.BarService;

/** TODO JAVADOC */
public class BarServiceTest extends ConcurrentTest<Void> {
	final Candle candle;

	public BarServiceTest() {
		super();
		BigDecimal open = new BigDecimal(1);
		BigDecimal high = new BigDecimal(2);
		BigDecimal low = new BigDecimal(1);
		BigDecimal close = new BigDecimal(2);
		BigDecimal volume = new BigDecimal(10);
		candle = new Candle(System.currentTimeMillis(), open, high, low, close, volume, System.currentTimeMillis(), new BigDecimal(1), 0L, new BigDecimal(1),
				new BigDecimal(1));
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
		assertEquals(new BigDecimal(bar.getOpenPrice().toString()), candle.open());
		assertEquals(new BigDecimal(bar.getHighPrice().toString()), candle.high());
		assertEquals(new BigDecimal(bar.getLowPrice().toString()), candle.low());
		assertEquals(new BigDecimal(bar.getClosePrice().toString()), candle.close());
		assertEquals(new BigDecimal(bar.getVolume().toString()), candle.volume());
		assertEquals(bar.getEndTime().toInstant().toEpochMilli(), candle.closeTime());
	}
}
