package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.depth.OrderBookRequest;

class GetOrderBookTest extends MarketTest {

	@Test
	@DisplayName("It should return the order book of the given symbol")
	void testGetTrades() throws ApiException {
		OrderBookRequest req = new OrderBookRequest(symbol);
		OrderBook history = client.getOrderBook(req).execute();
		test(history);
	}

	@Test
	@DisplayName("It should return the order book of the given symbol with the given limit")
	void testGetTradesWithLimit() throws ApiException {
		OrderBookRequest req = new OrderBookRequest(symbol, limit);
		OrderBook orderBook = client.getOrderBook(req).execute();

		assertEquals(limit, orderBook.getAsks().size());
		assertEquals(limit, orderBook.getBids().size());
		test(orderBook);
	}
}
