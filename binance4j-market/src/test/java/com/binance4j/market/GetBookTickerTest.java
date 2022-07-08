package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.depth.BookTicker;
import com.binance4j.market.depth.BookTickerRequest;
import com.binance4j.market.depth.BookTickersRequest;

class GetBookTickerTest extends MarketTest {

	@Test
	@DisplayName("Response must not contain null properties")
	void test1() throws ApiException {
		List<BookTicker> bookTickers = client.getBookTicker().execute();
		test(bookTickers);
	}

	@Test
	@DisplayName("Response must not contain null properties and match the given symbol")
	void test2() throws ApiException {
		BookTickerRequest req = new BookTickerRequest(symbol);
		BookTicker bookTicker = client.getBookTicker(req).execute();

		assertEquals(bookTicker.getSymbol(), symbol);
		test(bookTicker);
	}

	@Test
	@DisplayName("Response must not contain null properties and match the given symbols")
	void test3() throws ApiException {
		BookTickersRequest req = new BookTickersRequest(symbols);
		List<BookTicker> bookTickers = client.getBookTicker(req).execute();

		bookTickers.forEach(bt -> assertTrue(symbols.contains(bt.getSymbol())));
		test(bookTickers);
	}
}
