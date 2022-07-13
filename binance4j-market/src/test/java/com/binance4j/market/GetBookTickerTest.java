package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.depth.BookTicker;
import com.binance4j.market.depth.BookTickerParams;
import com.binance4j.market.depth.BookTickersParams;

class GetBookTickerTest extends MarketTest {

	@Test
	void test1() throws ApiException {
		List<BookTicker> bookTickers = client.getBookTicker().execute();
		test(bookTickers);
	}

	@Test
	void test2() throws ApiException {
		BookTickerParams params = new BookTickerParams(symbol);
		BookTicker bookTicker = client.getBookTicker(params).execute();

		assertEquals(bookTicker.getSymbol(), symbol);
		test(bookTicker);
	}

	@Test
	void test3() throws ApiException {
		BookTickersParams params = new BookTickersParams(symbols);
		List<BookTicker> bookTickers = client.getBookTicker(params).execute();

		bookTickers.forEach(bt -> assertTrue(symbols.contains(bt.getSymbol())));
		test(bookTickers);
	}
}
