package com.binance4j.websocket.trade;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/** Websocket client handling trade events on one or many symbols */
public class WebsocketTradeClient extends BaseWebsocketClient<TradePayload> {
	/**
	 * @param symbols  The symbols we want the data.
	 * @param callback The events handler.
	 */
	public WebsocketTradeClient(String symbols, WebsocketCallback<TradePayload> callback) {
		super(symbols, "trade", TradePayload.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param callback The events handler.
	 */
	public WebsocketTradeClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<TradePayload> callback) {
		this(String.join(",", symbols), callback);
	}
}
