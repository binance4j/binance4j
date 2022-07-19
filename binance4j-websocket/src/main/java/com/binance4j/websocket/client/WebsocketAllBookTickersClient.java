package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.BookTicker;

/** Websocket client handling book ticker events on all symbols */
public class WebsocketAllBookTickersClient extends BaseWebsocketClient<BookTicker> {
	/**
	 * @param callback The events handler.
	 */
	public WebsocketAllBookTickersClient(WebsocketCallback<BookTicker> callback) {
		super(null, "!bookTicker", BookTicker.class, callback);
	}
}
