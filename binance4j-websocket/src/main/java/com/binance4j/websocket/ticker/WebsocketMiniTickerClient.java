package com.binance4j.websocket.ticker;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling mini events on one or many symbols
 */
public class WebsocketMiniTickerClient extends BaseWebsocketClient<MiniTickerPayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  The symbols we want the data
	 * @param callback The events handler
	 */
	public WebsocketMiniTickerClient(String symbols, WebsocketCallback<MiniTickerPayload> callback) {
		super(symbols, "miniTicker", MiniTickerPayload.class, callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param callback The events handler
	 */
	public WebsocketMiniTickerClient(Iterable<? extends CharSequence> symbols,
	                                 WebsocketCallback<MiniTickerPayload> callback) {
		this(String.join(",", symbols), callback);
	}
}
