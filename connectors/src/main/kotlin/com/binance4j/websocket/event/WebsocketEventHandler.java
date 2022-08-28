package com.binance4j.websocket.event;

import java.time.Duration;

/** Base of any websocket event handler */
public interface WebsocketEventHandler {
	/** Rune the handler */
	void run();

	/** Cancel the handler */
	void cancel();

	/**
	 * Disconnect the websocket.
	 * 
	 * @param timeout Timeout to disconnect the handler.
	 */
	void disconnect(Duration timeout);
}
