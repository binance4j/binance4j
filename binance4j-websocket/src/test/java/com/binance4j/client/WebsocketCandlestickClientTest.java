package com.binance4j.client;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;
import com.binance4j.websocket.client.BaseWebsocketClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class WebsocketCandlestickClientTest extends BaseWebsocketClientTest<CandlePayload> {
	@Test
	@Override
	public void test() {
		super.test();
	}

	@Override
	protected BaseWebsocketClient<CandlePayload> newClient(TestCallback<CandlePayload> callback) {
		return new WebsocketCandlestickClient(TestService.SYMBOL, CandlestickInterval.ONE_MINUTE, callback);
	}

	@Override
	protected WebsocketTester<CandlePayload> newTester(TestCallback<CandlePayload> callback) {
		return new Tester(callback);
	}

	static class Tester extends WebsocketTester<CandlePayload> {

		/**
		 *
		 */
		public Tester(TestCallback<CandlePayload> callback) {
			super(callback);
		}

		@Override
		public void testMessageContent(CandlePayload message) {
			assertNotNull(message.getClose());
			assertNotNull(message.getCloseTime());
			assertNotNull(message.getEventTime());
			assertNotNull(message.getEventType());
			assertNotNull(message.getFirstTradeId());
			assertNotNull(message.getHigh());
			assertNotNull(message.getIntervalId());
			assertNotNull(message.getIsBarFinal());
			assertNotNull(message.getLastTradeId());
			assertNotNull(message.getLow());
			assertNotNull(message.getNumberOfTrades());
			assertNotNull(message.getOpen());
			assertNotNull(message.getOpenTime());
			assertNotNull(message.getQuoteAssetVolume());
			assertNotNull(message.getSymbol());
			assertNotNull(message.getTakerBuyBaseAssetVolume());
			assertNotNull(message.getTakerBuyQuoteAssetVolume());
			assertNotNull(message.getVolume());
		}
	}
}
