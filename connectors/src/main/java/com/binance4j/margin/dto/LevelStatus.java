package com.binance4j.margin.dto;

/** The margin level status */
public enum LevelStatus {
	/** Excessive */
	EXCESSIVE,
	/** Normal */
	NORMAL,
	/** Margin call */
	MARGIN_CALL,
	/** Pre liquidation */
	PRE_LIQUIDATION,
	/** Force liquidation */
	FORCE_LIQUIDATION
}
