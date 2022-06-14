package com.binance4j.websocket.depth;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling book ticker events on one or many symbols
 */
public class WebsocketBookTickerClient extends BaseWebsocketClient<BookTickerPayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  trading pair separated by a coma
	 * @param callback The events handler
	 */
	public WebsocketBookTickerClient(String symbols, WebsocketCallback<BookTickerPayload> callback) {
		super(symbols, "bookTicker", BookTickerPayload.class, callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param callback The events handler
	 */
	public WebsocketBookTickerClient(Iterable<? extends CharSequence> symbols,
	                                 WebsocketCallback<BookTickerPayload> callback) {
		this(String.join(",", symbols), callback);
	}
}