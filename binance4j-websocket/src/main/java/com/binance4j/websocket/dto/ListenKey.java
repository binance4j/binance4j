package com.binance4j.websocket.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** A wrapper for the listen key */
@JsonIgnoreProperties(ignoreUnknown = true)
public record ListenKey(
		/** The key used to open a user data stream. */
		String listenKey) {
}