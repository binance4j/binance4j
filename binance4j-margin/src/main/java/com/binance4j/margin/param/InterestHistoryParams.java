package com.binance4j.margin.param;

import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getInterestHistory} params. */
public class InterestHistoryParams extends Params {
	/** The starting timestamp of the results */
	private Long startTime;
	/** The ending timestamp of the results */
	private Long endTime;

	/** The related asset. */
	private String asset;
	/** isolated symbol. */
	private String isolatedSymbol;
	/** the tranId in POST /sapi/v1/margin/repay. */
	private long txId;
	/** Currently querying page. Start from 1. Default:1 */
	private long current;
	/** Default:10 Max:100 */
	private long size;
	/** Set to true for archived data from 6 months ago. */
	private Boolean archived;

	/** @param asset The asset */
	public InterestHistoryParams(String asset) {
		super();
		this.asset = asset;
	}

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the isolatedSymbol */
	public String getIsolatedSymbol() {
		return isolatedSymbol;
	}

	/** @param isolatedSymbol the isolatedSymbol to set */
	public void setIsolatedSymbol(String isolatedSymbol) {
		this.isolatedSymbol = isolatedSymbol;
	}

	/** @return the txId */
	public long getTxId() {
		return txId;
	}

	/** @param txId the txId to set */
	public void setTxId(long txId) {
		this.txId = txId;
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

	/** @return the archived */
	public Boolean getArchived() {
		return archived;
	}

	/** @param archived the archived to set */
	public void setArchived(Boolean archived) {
		this.archived = archived;
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