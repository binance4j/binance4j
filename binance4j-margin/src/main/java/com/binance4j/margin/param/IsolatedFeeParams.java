package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getIsolatedFeeData} params. */
public class IsolatedFeeParams extends Params {
	/** The request timestamp */
	private long timestamp = System.currentTimeMillis();
	/** The symbol */
	private final String symbol;
	/** The VIP level */
	private Integer vipLevel;

	/** Default constructor */
	public IsolatedFeeParams() {
		super(10);
		symbol = null;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @return the vipLevel */
	public Integer getVipLevel() {
		return vipLevel;
	}

	/** @param vipLevel the vipLevel to set */
	public void setVipLevel(Integer vipLevel) {
		this.vipLevel = vipLevel;
	}

	/** @return the timestamp */
	public long getTimestamp() {
		return timestamp;
	}

	/** @param timestamp the timestamp to set */
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}