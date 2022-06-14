package com.binance4j.websocket.trade;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling Aggregate trade events on a symbol or symbols
 */
public class WebsocketAggTradeClient extends BaseWebsocketClient<AggTradePayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  trading pair separated by a coma
	 * @param callback The events handler
	 */
	public WebsocketAggTradeClient(String symbols, WebsocketCallback<AggTradePayload> callback) {
		super(symbols, "aggTrade", AggTradePayload.class, callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param callback The events handler
	 */
	public WebsocketAggTradeClient(Iterable<? extends CharSequence> symbols,
	                               WebsocketCallback<AggTradePayload> callback) {
		this(String.join(",", symbols), callback);
	}
}