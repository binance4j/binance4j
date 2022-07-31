package com.binance4j.websocket.client;

import com.binance4j.websocket.callback.WebsocketCallback;
import com.binance4j.websocket.dto.BLVT;

/**
 * Websocket client handling BLVT info events on all symbols.
 * 
 * @deprecated Disconnected right after after connection.
 */
public class WebsocketBLVTInfoClient extends WebsocketBLVTClient<BLVT> {
	/**
	 * @param symbol   Trading pair separated by a coma.
	 * @param callback The events handler.
	 */
	public WebsocketBLVTInfoClient(String symbol, WebsocketCallback<BLVT> callback) {
		super(symbol, "tokenNav", BLVT.class, callback);
	}
}
