package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.AggTrade;

/** Websocket client handling Aggregate trade events on a symbol or symbols */
public class WebsocketAggTradeClient extends BaseWebsocketClient<AggTrade> {
	/**
	 * @param symbols  trading pair separated by a coma.
	 * @param callback The events handler.
	 */
	public WebsocketAggTradeClient(String symbols, WebsocketCallback<AggTrade> callback) {
		super(symbols, "aggTrade", AggTrade.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param callback The events handler.
	 */
	public WebsocketAggTradeClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<AggTrade> callback) {
		this(String.join(",", symbols), callback);
	}
}