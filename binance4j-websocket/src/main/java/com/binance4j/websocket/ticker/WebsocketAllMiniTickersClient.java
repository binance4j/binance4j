package com.binance4j.websocket.ticker;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.client.BaseWebsocketClient;

/**
 * Websocket client handling mini ticker events on all
 * symbols.
 */
public class WebsocketAllMiniTickersClient extends BaseWebsocketClient<MiniTickerPayload> {
	/**
	 * Constructor
	 *
	 * @param callback The events handler
	 */
	public WebsocketAllMiniTickersClient(WebsocketCallback<MiniTickerPayload> callback) {
		super(null, "!miniTicker", MiniTickerPayload.class, callback);
	}
}
