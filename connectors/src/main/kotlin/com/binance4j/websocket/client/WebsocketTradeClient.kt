package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Trade;

/** Websocket client handling trade events on one or many symbols */
public class WebsocketTradeClient extends BaseWebsocketClient<Trade> {
	/**
	 * @param symbols  Symbols we want the data.
	 * @param callback Events handler.
	 */
	public WebsocketTradeClient(String symbols, WebsocketCallback<Trade> callback) {
		super(symbols, "trade", Trade.class, callback);
	}

	/**
	 * @param symbols  Trading pair iterable.
	 * @param callback Events handler.
	 */
	public WebsocketTradeClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<Trade> callback) {
		this(String.join(",", symbols), callback);
	}
}
