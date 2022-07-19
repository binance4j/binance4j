package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.BookTicker;

/** Websocket client handling book ticker events on one or many symbols */
public class WebsocketBookTickerClient extends BaseWebsocketClient<BookTicker> {
	/**
	 * @param symbols  trading pair separated by a coma.
	 * @param callback The events handler.
	 */
	public WebsocketBookTickerClient(String symbols, WebsocketCallback<BookTicker> callback) {
		super(symbols, "bookTicker", BookTicker.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param callback The events handler.
	 */
	public WebsocketBookTickerClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<BookTicker> callback) {
		this(String.join(",", symbols), callback);
	}
}