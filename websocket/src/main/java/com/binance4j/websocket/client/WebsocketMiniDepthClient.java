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
	 * @param symbols  Symbols we want the data.
	 * @param level    Order book size.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 */
	public WebsocketMiniDepthClient(String symbols, DepthLevel level, DepthUpdateSpeed speed,
			WebsocketCallback<MiniDepth> callback) {
		super(symbols, String.format("depth%s@%s", level.toString(), speed.toString()), MiniDepth.class, callback);
	}

	/**
	 * @param symbols  Trading pair iterable.
	 * @param level    Order book size.
	 * @param speed    Update speed.
	 * @param callback Events handler.
	 */
	public WebsocketMiniDepthClient(Iterable<? extends CharSequence> symbols, DepthLevel level, DepthUpdateSpeed speed,
			WebsocketCallback<MiniDepth> callback) {
		this(String.join(",", symbols), level, speed, callback);
	}
}
