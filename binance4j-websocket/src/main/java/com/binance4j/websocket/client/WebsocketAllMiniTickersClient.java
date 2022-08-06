package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.MiniTicker;

/**
 * Websocket client handling mini ticker events on all symbols.
 */
public class WebsocketAllMiniTickersClient extends BaseWebsocketClient<MiniTicker> {
	/**
	 * @param callback Events handler.
	 */
	public WebsocketAllMiniTickersClient(WebsocketCallback<MiniTicker> callback) {
		super(null, "!miniTicker", MiniTicker.class, callback);
	}
}
