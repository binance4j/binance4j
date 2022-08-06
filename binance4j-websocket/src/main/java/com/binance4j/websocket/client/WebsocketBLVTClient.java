package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;

/** BVLT websocket client base class. */
public abstract class WebsocketBLVTClient<T> extends BaseWebsocketClient<T> {
	/**
	 * @param symbol       Trading pair separated by a coma.
	 * @param stream       Stream name.
	 * @param payloadClass Payload class.
	 * @param callback     Events handler.
	 */
	public WebsocketBLVTClient(String symbol, String stream, Class<T> payloadClass, WebsocketCallback<T> callback) {
		super(symbol, stream, payloadClass, callback);
		configuration.setBaseUrl("wss://nbstream.binance.com/lvt-p");
		generateChannel(false);
	}
}