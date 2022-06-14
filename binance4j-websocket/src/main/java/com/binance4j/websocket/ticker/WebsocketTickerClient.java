package com.binance4j.websocket.ticker;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Handles 24hr rolling window ticker statistics for a single symbol. These are
 * NOT the
 * statistics of the UTC day, but a 24hr rolling window for the previous 24hrs.
 */
public class WebsocketTickerClient extends BaseWebsocketClient<TickerPayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  The symbols we want the data
	 * @param callback The events handler
	 */
	public WebsocketTickerClient(String symbols, WebsocketCallback<TickerPayload> callback) {
		super(symbols, "ticker", TickerPayload.class, callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param callback The events handler
	 */
	public WebsocketTickerClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<TickerPayload> callback) {
		this(String.join(",", symbols), callback);
	}
}
