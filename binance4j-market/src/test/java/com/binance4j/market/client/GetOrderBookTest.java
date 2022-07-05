package com.binance4j.market.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.core.test.ConcurrentTest;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.depth.OrderBookRequest;
import com.binance4j.market.service.TestService;

class GetOrderBookTest extends ConcurrentTest {
	final MarketClient client = TestService.CLIENT;

	static void test(OrderBook orderBook) {
		assertTrue(TestService.hasNoNullProperty(orderBook));
		orderBook.getAsks().forEach(ask -> assertTrue(TestService.hasNoNullProperty(ask)));
		orderBook.getBids().forEach(bid -> assertTrue(TestService.hasNoNullProperty(bid)));
	}

	@Test
	@DisplayName("It should return the order book of the given symbol")
	void testGetTrades() throws ApiException {
		OrderBookRequest req = new OrderBookRequest(TestService.SYMBOL);
		OrderBook history = client.getOrderBook(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the order book of the given symbol with the given limit")
	void testGetTradesWithLimit() throws ApiException {
		int limit = 25;
		OrderBookRequest req = new OrderBookRequest(TestService.SYMBOL, limit);
		OrderBook orderBook = client.getOrderBook(req).execute();

		assertEquals(limit, orderBook.getAsks().size());
		assertEquals(limit, orderBook.getBids().size());
		test(orderBook);
	}
}
