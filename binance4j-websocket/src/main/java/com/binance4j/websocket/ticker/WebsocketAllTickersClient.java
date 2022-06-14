package com.binance4j.websocket.ticker;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling ticker events on all
 * symbols.
 */
public class WebsocketAllTickersClient extends BaseWebsocketClient<TickerPayload> {
	/**
	 * Constructor
	 *
	 * @param callback The events handler
	 */
	public WebsocketAllTickersClient(WebsocketCallback<TickerPayload> callback) {
		super(null, "!ticker", TickerPayload.class, callback);
	}
}
