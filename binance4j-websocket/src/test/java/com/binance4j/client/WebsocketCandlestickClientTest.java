package com.binance4j.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.binance4j.core.market.CandlestickInterval;
import com.binance4j.service.TestService;
import com.binance4j.utils.BaseWebsocketClientTest;
import com.binance4j.utils.TestCallback;
import com.binance4j.utils.WebsocketTester;
import com.binance4j.websocket.candle.CandlePayload;
import com.binance4j.websocket.candle.WebsocketCandlestickClient;
import com.binance4j.websocket.client.BaseWebsocketClient;

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
			System.out.println(message.getClose());
			assertNotNull(message.getClose());
			System.out.println(message.getCloseTime());
			assertNotNull(message.getCloseTime());
			System.out.println(message.getEventTime());
			assertNotNull(message.getEventTime());
			System.out.println(message.getEventType());
			assertNotNull(message.getEventType());
			System.out.println(message.getFirstTradeId());
			assertNotNull(message.getFirstTradeId());
			System.out.println(message.getHigh());
			assertNotNull(message.getHigh());
			System.out.println(message.getIntervalId());
			assertNotNull(message.getIntervalId());
			System.out.println(message.isBarFinal());
			assertNotNull(message.isBarFinal());
			System.out.println(message.getLastTradeId());
			assertNotNull(message.getLastTradeId());
			System.out.println(message.getLow());
			assertNotNull(message.getLow());
			System.out.println(message.getNumberOfTrades());
			assertNotNull(message.getNumberOfTrades());
			System.out.println(message.getOpen());
			assertNotNull(message.getOpen());
			System.out.println(message.getOpenTime());
			assertNotNull(message.getOpenTime());
			System.out.println(message.getQuoteAssetVolume());
			assertNotNull(message.getQuoteAssetVolume());
			System.out.println(message.getSymbol());
			assertNotNull(message.getSymbol());
			System.out.println(message.getTakerBuyBaseAssetVolume());
			assertNotNull(message.getTakerBuyBaseAssetVolume());
			System.out.println(message.getTakerBuyQuoteAssetVolume());
			assertNotNull(message.getTakerBuyQuoteAssetVolume());
			System.out.println(message.getVolume());
			assertNotNull(message.getVolume());
		}
	}
}
