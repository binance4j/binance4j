package com.binance4j.strategy;

import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.strategy.service.BarService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ta4j.core.Bar;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BarServiceTest {
	final Candle candle = new Candle();

	public BarServiceTest() {
		long closeTime = new Date().getTime();
		BigDecimal open = new BigDecimal(1);
		BigDecimal high = new BigDecimal(2);
		BigDecimal low = new BigDecimal(1);
		BigDecimal close = new BigDecimal(2);
		BigDecimal volume = new BigDecimal(10);
		candle.setCloseTime(closeTime);
		candle.setOpen(open);
		candle.setHigh(high);
		candle.setLow(low);
		candle.setClose(close);
		candle.setVolume(volume);
	}

	@Test
	@DisplayName("output properties should be the same as input properties")
	void convertWithDuration() {
		Bar bar = BarService.convert(candle, Duration.ofMinutes(5));
		assertValues(bar, candle);
	}

	@Test
	@DisplayName("output properties should be the same as input properties")
	void testConvert2() {
		Bar bar = BarService.convert(candle, CandlestickInterval.FIVE_MINUTES);
		assertValues(bar, candle);
	}

	@Test
	@DisplayName("output properties should be the same as input properties")
	void testConvert3() {
		Bar bar = BarService.convert(candle, CandlestickInterval.FIVE_MINUTES);
		assertValues(bar, candle);
	}

	void assertValues(Bar bar, Candle candle) {
		assertEquals(new BigDecimal(bar.getOpenPrice().toString()), candle.getOpen());
		assertEquals(new BigDecimal(bar.getHighPrice().toString()), candle.getHigh());
		assertEquals(new BigDecimal(bar.getLowPrice().toString()), candle.getLow());
		assertEquals(new BigDecimal(bar.getClosePrice().toString()), candle.getClose());
		assertEquals(new BigDecimal(bar.getVolume().toString()), candle.getVolume());
		assertEquals(bar.getEndTime().toInstant().toEpochMilli(), candle.getCloseTime());
	}
}
