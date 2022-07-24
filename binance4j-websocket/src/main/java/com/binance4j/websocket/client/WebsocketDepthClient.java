package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.Depth;
import com.binance4j.websocket.dto.DepthUpdateSpeed;

/** Websocket client handling depth events on one or many symbols */
public class WebsocketDepthClient extends BaseWebsocketClient<Depth> {
	/**
	 * @param symbols  The symbols we want the data.
	 * @param speed    the update speed.
	 * @param callback The events handler.
	 */
	public WebsocketDepthClient(String symbols, DepthUpdateSpeed speed, WebsocketCallback<Depth> callback) {
		super(symbols, String.format("depth@%s", speed.toString()), Depth.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param speed    the update speed.
	 * @param callback The events handler.
	 */
	public WebsocketDepthClient(Iterable<? extends CharSequence> symbols, DepthUpdateSpeed speed, WebsocketCallback<Depth> callback) {
		this(String.join(",", symbols), speed, callback);
	}
}
