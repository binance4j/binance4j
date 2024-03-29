package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Ticker;

/**
 * Handles 24hr rolling window ticker statistics for a single symbol. These are
 * NOT the statistics of the UTC day, but a
 * 24hr rolling window for the previous 24hrs.
 */
public class WebsocketTickerClient extends BaseWebsocketClient<Ticker> {
	/**
	 * @param symbols  Symbols we want the data.
	 * @param callback Events handler.
	 */
	public WebsocketTickerClient(String symbols, WebsocketCallback<Ticker> callback) {
		super(symbols, "ticker", Ticker.class, callback);
	}

	/**
	 * @param symbols  Trading pair iterable.
	 * @param callback Events handler.
	 */
	public WebsocketTickerClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<Ticker> callback) {
		this(String.join(",", symbols), callback);
	}
}
