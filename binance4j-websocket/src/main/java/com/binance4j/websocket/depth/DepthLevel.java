package com.binance4j.websocket.depth;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The order book size
 */
@AllArgsConstructor
public enum DepthLevel {
	/**
	 * Depth of 5 results
	 */
	LEVEL_5("5"),
	/**
	 * Depth of 10 results
	 */
	LEVEL_10("10"),
	/**
	 * Depth of 20 results
	 */
	LEVEL_20("20");

	/**
	 * The result size
	 */
	@Getter
	private final String level;
}
