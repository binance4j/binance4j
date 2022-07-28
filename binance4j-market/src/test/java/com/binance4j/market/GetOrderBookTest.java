package com.binance4j.market;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.binance4j.core.exception.ApiException;
import com.binance4j.market.dto.OrderBook;
import com.binance4j.market.dto.OrderBookLimit;
import com.binance4j.market.param.OrderBookParams;

class GetOrderBookTest extends MarketTest {

	@Test
	void testGetTrades() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol);
		OrderBook history = client.getOrderBook(params).execute();
		testNoNulls(history);
	}

	@Test
	void testGetTradesWithLimit() throws ApiException {
		OrderBookParams params = new OrderBookParams(symbol, OrderBookLimit.LIMIT_10);
		OrderBook orderBook = client.getOrderBook(params).execute();

		assertEquals(limit, orderBook.asks().size());
		assertEquals(limit, orderBook.bids().size());
		testNoNulls(orderBook);
	}
}
