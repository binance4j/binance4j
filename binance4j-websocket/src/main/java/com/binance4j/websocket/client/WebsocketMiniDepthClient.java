package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.DepthLevel;
import com.binance4j.websocket.dto.DepthUpdateSpeed;
import com.binance4j.websocket.dto.MiniDepth;

/**
 * Websocket client handling top bids and asks events on one or many symbols ²
 */
public class WebsocketMiniDepthClient extends BaseWebsocketClient<MiniDepth> {
	/**
	 * @param symbols  The symbols we want the data.
	 * @param level    The order book size.
	 * @param speed    the update speed.
	 * @param callback The events handler.
	 */
	public WebsocketMiniDepthClient(String symbols, DepthLevel level, DepthUpdateSpeed speed, WebsocketCallback<MiniDepth> callback) {
		super(symbols, String.format("depth%s@%s", level.getLevel(), speed.getValue()), MiniDepth.class, callback);
	}

	/**
	 * @param symbols  The trading pair iterable.
	 * @param level    The order book size.
	 * @param speed    the update speed.
	 * @param callback The events handler.
	 */
	public WebsocketMiniDepthClient(Iterable<? extends CharSequence> symbols, DepthLevel level, DepthUpdateSpeed speed, WebsocketCallback<MiniDepth> callback) {
		this(String.join(",", symbols), level, speed, callback);
	}
}
