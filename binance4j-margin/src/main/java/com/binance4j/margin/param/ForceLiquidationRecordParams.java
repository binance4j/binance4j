package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getForceLiquidationRecord} params. */
@Param
public class ForceLiquidationRecordParams implements Params {
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;

	/** isolated symbol. */
	String isolatedSymbol;
	/** Currently querying page. Start from 1. Default:1 */
	long current;
	/** Default:10 Max:100 */
	long size;

	/** @return the isolatedSymbol */
	public String getIsolatedSymbol() {
		return isolatedSymbol;
	}

	/** @param isolatedSymbol the isolatedSymbol to set */
	public void setIsolatedSymbol(String isolatedSymbol) {
		this.isolatedSymbol = isolatedSymbol;
	}

	/** @return the current */
	public long getCurrent() {
		return current;
	}

	/** @param current the current to set */
	public void setCurrent(long current) {
		this.current = current;
	}

	/** @return the size */
	public long getSize() {
		return size;
	}

	/** @param size the size to set */
	public void setSize(long size) {
		this.size = size;
	}

	/** @return the startTime */
	public Long getStartTime() {
		return startTime;
	}

	/** @param startTime the startTime to set */
	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	/** @return the endTime */
	public Long getEndTime() {
		return endTime;
	}

	/** @param endTime the endTime to set */
	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}
}
