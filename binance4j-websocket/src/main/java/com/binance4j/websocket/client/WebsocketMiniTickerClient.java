package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.MiniTicker;

/** Websocket client handling mini events on one or many symbols */
public class WebsocketMiniTickerClient extends BaseWebsocketClient<MiniTicker> {
	/**
	 * @param symbols  Symbols we want the data.
	 * @param callback Events handler.
	 */
	public WebsocketMiniTickerClient(String symbols, WebsocketCallback<MiniTicker> callback) {
		super(symbols, "miniTicker", MiniTicker.class, callback);
	}

	/**
	 * @param symbols  Trading pair iterable.
	 * @param callback Events handler.
	 */
	public WebsocketMiniTickerClient(Iterable<? extends CharSequence> symbols, WebsocketCallback<MiniTicker> callback) {
		this(String.join(",", symbols), callback);
	}
}
