package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.BookTicker;
import com.binance4j.market.param.BookTickerParams;
import com.binance4j.market.param.BookTickersParams;

class GetBookTickerTest extends MarketTest {
	@Test
	void test1() throws ApiException {
		List<BookTicker> bookTickers = client.getBookTicker().fetch();
		testNoNulls(bookTickers);
	}

	@Test
	void test2() throws ApiException {
		BookTickerParams params = new BookTickerParams(symbol);
		BookTicker bookTicker = client.getBookTicker(params).fetch();
		assertEquals(bookTicker.symbol(), symbol);
		testNoNulls(bookTicker);
	}

	@Test
	void test3() throws ApiException {
		BookTickersParams params = new BookTickersParams(symbols);
		List<BookTicker> bookTickers = client.getBookTicker(params).fetch();
		bookTickers.forEach(bt -> assertTrue(symbols.contains(bt.symbol())));
		testNoNulls(bookTickers);
	}
}
