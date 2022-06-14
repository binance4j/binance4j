package com.binance4j.client;

import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.client.BaseWebsocketClient;
import com.binance4j.websocket.ticker.TickerPayload;
import com.binance4j.websocket.ticker.WebsocketTickerClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketTickerClientTest extends BaseWebsocketClientTest<TickerPayload> {

	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<TickerPayload> newClient(TestCallback<TickerPayload> callback) {
		return new WebsocketTickerClient(TestService.SYMBOL, callback);

	}

	@Override
	protected WebsocketTester<TickerPayload> newTester(TestCallback<TickerPayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<TickerPayload> {

		/**
		 *
		 */
		public Tester(TestCallback<TickerPayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(TickerPayload message) {

			assertNotNull(message.getBestAskPrice());
			assertNotNull(message.getBestAskQuantity());
			assertNotNull(message.getBestBidPrice());
			assertNotNull(message.getBestBidQuantity());
			assertNotNull(message.getCloseTradesQuantity());
			assertNotNull(message.getCurrentDaysClosePrice());
			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());
			assertNotNull(message.getFirstTradeId());
			assertNotNull(message.getHighPrice());
			assertNotNull(message.getLastTradeId());
			assertNotNull(message.getLowPrice());
			assertNotNull(message.getOpenPrice());
			assertNotNull(message.getPreviousDaysClosePrice());
			assertNotNull(message.getPriceChange());
			assertNotNull(message.getPriceChangePercent());
			assertNotNull(message.getStatisticsCloseTime());
			assertNotNull(message.getStatisticsOpenTime());
			assertNotNull(message.getSymbol());
			assertNotNull(message.getTotalNumberOfTrades());
			assertNotNull(message.getTotalTradedBaseAssetVolume());
			assertNotNull(message.getTotalTradedQuoteAssetVolume());
			assertNotNull(message.getWeightedAveragePrice());
		}
	}
}
