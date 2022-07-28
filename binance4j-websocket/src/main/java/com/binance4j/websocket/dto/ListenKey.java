package com.binance4j.websocket.dto;

/**
 * A wrapper for the listen key.
 * 
 * @param listenKey The key used to open a user data stream.
 */
public record ListenKey(
		/** The key used to open a user data stream. */
		String listenKey) {
}