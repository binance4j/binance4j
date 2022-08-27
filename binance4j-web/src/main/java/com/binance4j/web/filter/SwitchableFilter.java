package com.binance4j.web.filter;

import com.binance4j.web.dto.BaseSwitchable;

/** Filter that can be enabled/disabled. */
public abstract class SwitchableFilter extends BaseSwitchable {

	/**
	 * @param enabled filter status.
	 */
	public SwitchableFilter(boolean enabled) {
		super(enabled);
	}

	/** */
	public SwitchableFilter() {
		super(false);
	}
}
