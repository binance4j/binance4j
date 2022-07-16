package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getForceLiquidationRecord} params. */
public class ForceLiquidationRecordParams extends IntervalParams {
	/** isolated symbol. */
	private String isolatedSymbol;
	/** Currently querying page. Start from 1. Default:1 */
	private long current;
	/** Default:10 Max:100 */
	private long size;

	/**
	 * @return the isolatedSymbol
	 */
	public String getIsolatedSymbol() {
		return isolatedSymbol;
	}

	/**
	 * @param isolatedSymbol the isolatedSymbol to set
	 */
	public void setIsolatedSymbol(String isolatedSymbol) {
		this.isolatedSymbol = isolatedSymbol;
	}

	/**
	 * @return the current
	 */
	public long getCurrent() {
		return current;
	}

	/**
	 * @param current the current to set
	 */
	public void setCurrent(long current) {
		this.current = current;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

}
