package com.binance4j.websocket.callback;

/** Contains the code and the reason of the websocket closing */
data class WebsocketCloseObject(
		/** The closing code. */
		int code,
		/** The closing reason. */
		String reason) {
}