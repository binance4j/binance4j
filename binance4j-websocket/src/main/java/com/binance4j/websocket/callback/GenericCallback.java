package com.binance4j.websocket.callback;

/** Genreic callback used as functional callback. */
public interface GenericCallback<T> {
	/**
	 * The main method.
	 * 
	 * @param data Data to pass.
	 */
	void call(T data);
}
