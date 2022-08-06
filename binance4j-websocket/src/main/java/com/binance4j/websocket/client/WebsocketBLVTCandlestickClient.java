package com.binance4j.websocket.client;

import com.binance4j.core.dto.CandlestickInterval;
import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.BLVTCandleEvent;

/**
 * Websocket client handling BLVT NAV kline events on all symbols.
 * 
 * @deprecated Disconnected right after after connection.
 */
public class WebsocketBLVTCandlestickClient extends WebsocketBLVTClient<BLVTCandleEvent> {
	/**
	 * @param symbol   Trading pair separated by a coma.
	 * @param interval Candlestick interval.
	 * @param callback Events handler.
	 */
	public WebsocketBLVTCandlestickClient(String symbol, CandlestickInterval interval, WebsocketCallback<BLVTCandleEvent> callback) {
		super(symbol, String.format("nav_kline_%s", interval), BLVTCandleEvent.class, callback);
	}
}
