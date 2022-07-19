package com.binance4j.websocket.dto;

/** The order book size */
public enum DepthLevel {
	/** Depth of 5 results. */
	LEVEL_5("5"),
	/** Depth of 10 results. */
	LEVEL_10("10"),
	/** Depth of 20 results. */
	LEVEL_20("20");

	/** The result size. */
	private final String level;

	/**
	 * @param level
	 */
	private DepthLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

}
