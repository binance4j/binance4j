package com.binance4j.web.dto;

/** Fors objects that can be enabled/disabled. */
public interface Switchable {
	/** Enable object. */
	void enable();

	/** Disable object. */
	void disable();
}
