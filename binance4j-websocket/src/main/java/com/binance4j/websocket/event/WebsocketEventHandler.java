package com.binance4j.websocket.event;

import java.time.Duration;

public interface WebsocketEventHandler {
	void run();

	void cancel();

	void disconnect(Duration timeout);
}
