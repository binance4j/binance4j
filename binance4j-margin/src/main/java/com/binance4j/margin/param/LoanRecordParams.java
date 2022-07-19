package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;
import com.binance4j.margin.client.MarginClient;

/** The {@link MarginClient#getLoanRecord} params. */
public class LoanRecordParams extends IntervalParams {
	/** The asset */
	private String asset;
	/** isolated symbol. */
	private String isolatedSymbol;
	/** the tranId in POST /sapi/v1/margin/loan. */
	private long txId;
	/** Currently querying page. Start from 1. Default:1 */
	private long current = 1;
	/** Default:10 Max:100 */
	private long size;
	/** Set to true for archived data from 6 months ago. */
	private Boolean archived;

	/** @param asset The asset */.
	public LoanRecordParams(String asset) {
		super(10);
		this.asset = asset;
	}

	/** @return the asset */.
	public String getAsset() {
		return asset;
	}

	/** @param asset the asset to set */.
	public void setAsset(String asset) {
		this.asset = asset;
	}

	/** @return the isolatedSymbol */.
	public String getIsolatedSymbol() {
		return isolatedSymbol;
	}

	/** @param isolatedSymbol the isolatedSymbol to set */.
	public void setIsolatedSymbol(String isolatedSymbol) {
		this.isolatedSymbol = isolatedSymbol;
	}

	/** @return the txId */.
	public long getTxId() {
		return txId;
	}

	/** @param txId the txId to set */.
	public void setTxId(long txId) {
		this.txId = txId;
	}

	/** @return the current */.
	public long getCurrent() {
		return current;
	}

	/** @param current the current to set */.
	public void setCurrent(long current) {
		this.current = current;
	}

	/** @return the size */.
	public long getSize() {
		return size;
	}

	/** @param size the size to set */.
	public void setSize(long size) {
		this.size = size;
	}

	/** @return the archived */.
	public Boolean getArchived() {
		return archived;
	}

	/** @param archived the archived to set */.
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
