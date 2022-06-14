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
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.service.TestService;
import com.binance4j.vision.spot.VisionSpotClient;
import com.binance4j.vision.spot.VisionTrade;

public class GetTradesTest {
	final VisionSpotClient client = TestService.CLIENT;
	final String symbol = TestService.SYMBOL;
	final String year = TestService.YEAR;
	final String month = TestService.MONTH;
	final String day = TestService.DAY;
	CandlestickInterval interval = TestService.INTERVAL;

	@Test
	@DisplayName("It should throw an InvalidDateException")
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getTrades(symbol, year, month, "32").getData());

		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	@DisplayName("It should throw a NotFoundException")
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getTrades(symbol, "1995", month, day).getData());

		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	@DisplayName("It should return the trades")
	void testGetTrades() throws ApiException {
		List<VisionTrade> trades = client.getTrades(symbol, year, month, day).getData();

		assertTrue(trades.size() > 0);
		trades.forEach(c -> {
			assertNotNull(c.getIsBestMatch());
			assertNotNull(c.getIsBuyerMaker());
			assertNotNull(c.getPrice());
			assertNotNull(c.getQuantity());
			assertNotNull(c.getQuoteQuantity());
			assertNotNull(c.getTime());
			assertNotNull(c.getTradeId());
		});
	}
}
