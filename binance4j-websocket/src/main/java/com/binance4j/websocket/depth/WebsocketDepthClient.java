package com.binance4j.websocket.depth;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling depth events on one or many symbols
 */
public class WebsocketDepthClient extends BaseWebsocketClient<DepthPayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  The symbols we want the data
	 * @param speed    the update speed
	 * @param callback The events handler
	 */
	public WebsocketDepthClient(String symbols, DepthUpdateSpeed speed, WebsocketCallback<DepthPayload> callback) {
		super(symbols, String.format("depth@%s", speed.getSpeed()), DepthPayload.class, callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param speed    the update speed
	 * @param callback The events handler
	 */
	public WebsocketDepthClient(Iterable<? extends CharSequence> symbols, DepthUpdateSpeed speed,
	                            WebsocketCallback<DepthPayload> callback) {
		this(String.join(",", symbols), speed, callback);
	}
}
