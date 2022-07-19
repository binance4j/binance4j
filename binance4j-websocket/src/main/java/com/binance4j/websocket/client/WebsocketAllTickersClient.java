package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Ticker;

/**
 * Websocket client handling ticker events on all symbols.
 */
public class WebsocketAllTickersClient extends BaseWebsocketClient<Ticker> {
	/**
	 * @param callback The events handler.
	 */
	public WebsocketAllTickersClient(WebsocketCallback<Ticker> callback) {
		super(null, "!ticker", Ticker.class, callback);
	}
}
