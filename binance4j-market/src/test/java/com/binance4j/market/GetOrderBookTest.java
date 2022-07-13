package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.depth.OrderBook;
import com.binance4j.market.depth.OrderBookParams;

class GetOrderBookTest extends MarketTest {

	@Test

	void testGetTrades() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol);
		OrderBook history = client.getOrderBook(params).execute();
		test(history);
	}

	@Test

	void testGetTradesWithLimit() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol, limit);
		OrderBook orderBook = client.getOrderBook(params).execute();

		assertEquals(limit, orderBook.getAsks().size());
		assertEquals(limit, orderBook.getBids().size());
		test(orderBook);
	}
}
