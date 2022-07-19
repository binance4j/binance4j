package com.binance4j.websocket.callback;

/** Genreic callback used as functional callback. */
public interface GenericCallback<T> {
	/**
	 * The main method.
	 * 
	 * @param data The data to pass.
	 */
	void call(T data);
}
