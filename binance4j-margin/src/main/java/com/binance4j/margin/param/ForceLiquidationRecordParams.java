package com.binance4j.margin.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ForceLiquidationRecordParams extends IntervalParams {
	/** isolated symbol */
	private String isolatedSymbol;
	/** Currently querying page. Start from 1. Default:1 */
	private long current;
	/** Default:10 Max:100 */
	private long size;

	public ForceLiquidationRecordParams() {
		super(1);
	}
}
