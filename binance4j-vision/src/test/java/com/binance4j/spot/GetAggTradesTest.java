package com.binance4j.spot;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.exception.InvalidDateException;
import com.binance4j.core.exception.NotFoundException;
import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.vision.spot.VisionSpotClient;

public class GetAggTradesTest {
	final VisionSpotClient client = CLIENT;
	final String symbol = getSymbol();
	final String year = YEAR;
	final String month = MONTH;
	final String day = DAY;
	CandlestickInterval interval = INTERVAL;

	@Test
	@DisplayName("It should throw an InvalidDateException")
	void testInvalidDate() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTrades(symbol, year, month, "32").getData());

		assertTrue(exception.getMessage().contains(new InvalidDateException().getMessage()));
	}

	@Test
	@DisplayName("It should throw a NotFoundException")
	void testNotFoundSync() {
		Exception exception = assertThrows(ApiException.class,
				() -> client.getAggTrades(symbol, "1995", month, day).getData());

		assertTrue(exception.getMessage().contains(new NotFoundException().getMessage()));
	}

	@Test
	@DisplayName("It should return the trades")
	void testgetAggTrades() throws ApiException {
		client.getAggTrades(symbol, year, month, day).getData()
				.forEach(trade -> assertTrue(hasNoNullProperty(trade)));
	}
}
