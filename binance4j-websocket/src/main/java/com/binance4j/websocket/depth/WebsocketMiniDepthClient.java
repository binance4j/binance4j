package com.binance4j.websocket.depth;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling top bids and asks events on one or many symbols
 * ²
 */
public class WebsocketMiniDepthClient extends BaseWebsocketClient<MiniDepthPayload> {
	/**
	 * Constructor
	 *
	 * @param symbols  The symbols we want the data
	 * @param level    The order book size
	 * @param speed    the update speed
	 * @param callback The events handler
	 */
	public WebsocketMiniDepthClient(String symbols, DepthLevel level, DepthUpdateSpeed speed,
	                                WebsocketCallback<MiniDepthPayload> callback) {
		super(symbols, String.format("depth%s@%s", level.getLevel(), speed.getSpeed()), MiniDepthPayload.class,
				callback);
	}

	/**
	 * Constructor
	 *
	 * @param symbols  The trading pair iterable
	 * @param level    The order book size
	 * @param speed    the update speed
	 * @param callback The events handler
	 */
	public WebsocketMiniDepthClient(Iterable<? extends CharSequence> symbols, DepthLevel level,
	                                DepthUpdateSpeed speed, WebsocketCallback<MiniDepthPayload> callback) {
		this(String.join(",", symbols), level, speed, callback);
	}
}
