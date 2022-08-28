package com.binance4j.web.dto;

/** Object that can be enabled/disabled. */
public abstract class BaseSwitchable:Switchable
{
	/** Object status. */
	boolean enabled;

	/**
	 * @property enabled object status.
	 */
	public BaseSwitchable(boolean enabled) {
		this.enabled = enabled;
	}

	/** Enable object. */
	public void enable() {
		enabled = true;
	}

	/** Disable object. */
	public void disable() {
		enabled = false;
	}
}
