package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.core.market.Candle;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.service.TestService;
import com.binance4j.vision.spot.VisionSpotClient;

public class GetKlinesTest {
	final VisionSpotClient client = TestService.CLIENT;
	final CandlestickInterval interval = TestService.INTERVAL;
	final String symbol = TestService.SYMBOL;
	final String year = TestService.YEAR;
	final String month = TestService.MONTH;
	final String day = TestService.DAY;

	@Test
	@DisplayName("It should throw an InvalidDateException")
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getKlines(symbol, interval, year, month, "32").getData());

		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	@DisplayName("It should throw a NotFoundException")
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getKlines(symbol, interval, "1995", month, day).getData());

		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	@DisplayName("It should return the klines")
	void testGetKlines() throws ApiException {
		List<Candle> candlestick = client.getKlines(symbol, interval, year, month, day).getData();

		assertTrue(candlestick.size() > 0);
		candlestick.forEach(c -> {
			assertNotNull(c.getClose());
			assertNotNull(c.getCloseTime());
			assertNotNull(c.getHigh());
			assertNotNull(c.getIgnore());
			assertNotNull(c.getLow());
			assertNotNull(c.getNumberOfTrades());
			assertNotNull(c.getOpen());
			assertNotNull(c.getOpenTime());
			assertNotNull(c.getQuoteAssetVolume());
			assertNotNull(c.getTakerBuyBaseAssetVolume());
			assertNotNull(c.getTakerBuyQuoteAssetVolume());
			assertNotNull(c.getVolume());
		});
	}
}
