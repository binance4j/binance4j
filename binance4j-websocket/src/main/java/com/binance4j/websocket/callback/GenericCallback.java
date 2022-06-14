package com.binance4j.websocket.callback;

public interface GenericCallback<T> {
	void call(T data);
}
