package com.binance4j.websocket.depth;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling book ticker events on all symbols
 */
public class WebsocketAllBookTickersClient extends BaseWebsocketClient<BookTickerPayload> {
	/**
	 * Constructor
	 *
	 * @param callback The events handler
	 */
	public WebsocketAllBookTickersClient(WebsocketCallback<BookTickerPayload> callback) {
		super(null, "!bookTicker", BookTickerPayload.class, callback);
	}
}
