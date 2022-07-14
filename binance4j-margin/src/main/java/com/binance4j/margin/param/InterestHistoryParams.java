package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InterestHistoryParams extends IntervalParams {
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

	public InterestHistoryParams(String asset) {
		super(1);
		this.asset = asset;
	}
}
