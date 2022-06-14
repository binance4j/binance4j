package com.binance4j.market.client;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.depth.BookTicker;
import com.binance4j.market.depth.BookTickerRequest;
import com.binance4j.market.depth.BookTickersRequest;
import com.binance4j.market.service.TestService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetBookTickerTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	static void test(BookTicker bookTicker) {
		assertNotNull(bookTicker.getAskPrice());
		assertNotNull(bookTicker.getAskQuantity());
		assertNotNull(bookTicker.getBidPrice());
		assertNotNull(bookTicker.getBidQuantity());
		assertNotNull(bookTicker.getSymbol());
	}

	static void test(List<BookTicker> bookTickers) {
		bookTickers.forEach(GetBookTickerTest::test);
	}

	@Test
	@DisplayName("It should return the book ticker of all symbols")
	void testGetAllBookTicker() throws ApiException {
		List<BookTicker> bookTickers = client.getBookTicker().execute();
		test(bookTickers);
	}

	@Test
	@DisplayName("It should return the book ticker of the given symbol")
	void testGetBookTickerOfOneSymbol() throws ApiException {
		BookTickerRequest req = new BookTickerRequest(TestService.SYMBOL);
		BookTicker bookTicker = client.getBookTicker(req).execute();

		assertEquals(bookTicker.getSymbol(), TestService.SYMBOL);
		test(bookTicker);
	}

	@Test
	@DisplayName("It should return the book ticker of the given symbols")
	void testGetBookTickerOfMultipleSymbols() throws ApiException {
		BookTickersRequest req = new BookTickersRequest(TestService.SYMBOLS);
		List<BookTicker> bookTickers = client.getBookTicker(req).execute();

		bookTickers.forEach(bt -> assertTrue(TestService.SYMBOLS.contains(bt.getSymbol())));
		test(bookTickers);
	}
}
