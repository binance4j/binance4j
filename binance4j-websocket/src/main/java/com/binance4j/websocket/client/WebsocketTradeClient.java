package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Trade;

/** Websocket client handling trade events on one or many symbols */
public class WebsocketTradeClient extends BaseWebsocketClient<Trade> {
	/**
	 * @param symbols  The symbols we want the data.
	 * @param callback The events handler.
	 */
	public WebsocketTradeClient(String symbols, WebsocketCallback<Trade> callback) {
		super(symbols, "trade", Trade.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param callback The events handler.
	 */
	public WebsocketTradeClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<Trade> callback) {
		this(String.join(",", symbols), callback);
	}
}
