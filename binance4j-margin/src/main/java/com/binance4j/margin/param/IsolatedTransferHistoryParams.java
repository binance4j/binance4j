package com.binance4j.margin.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;
import com.binance4j.margin.dto.IsolatedTransferAccount;

/** The {@link MarginClient#getIsolatedTransferHistory} params. */
public class IsolatedTransferHistoryParams extends Params {
	/** The symbol. */
	@Mandatory
	String symbol;
	/** The starting timestamp of the results */
	Long startTime;
	/** The ending timestamp of the results */
	Long endTime;
	/** The asset. */
	String asset;
	/** The transfer origin. */
	IsolatedTransferAccount transFrom;
	/** The transfer destination. */
	IsolatedTransferAccount transTo;
	/** Current page, default 1. */
	Long current;
	/** The paresult size. Default 10, max 100 */
	Integer size;
	/** Set to true for archived data from 6 months ago. */
	Boolean archived;

	/** @param symbol The symbol */
	public IsolatedTransferHistoryParams(String symbol) {
		super();
		this.symbol = symbol;
	}

	/** @return the asset */
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the symbol */
	public String getSymbol() {
		return symbol;
	}

	/** @param symbol the symbol to set */
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	/** @return the transFrom */
	public IsolatedTransferAccount getTransFrom() {
		return transFrom;
	}

	/** @param transFrom the transFrom to set */
	public void setTransFrom(IsolatedTransferAccount transFrom) {
		this.transFrom = transFrom;
	}

	/** @return the transTo */
	public IsolatedTransferAccount getTransTo() {
		return transTo;
	}

	/** @param transTo the transTo to set */
	public void setTransTo(IsolatedTransferAccount transTo) {
		this.transTo = transTo;
	}

	/** @return the current */
	public Long getCurrent() {
		return current;
	}

	/** @param current the current to set */
	public void setCurrent(Long current) {
		this.current = current;
	}

	/** @return the size */
	public Integer getSize() {
		return size;
	}

	/** @param size the size to set */
	public void setSize(Integer size) {
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
