package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/**
 * {@link MarginClient#getForceLiquidationRecord} params.
 * 
 * @param isolatedSymbol Isolated symbol.
 */
@Param
public record ForceLiquidationRecordParams(String isolatedSymbol) implements Params {

	/**
	 * @Creates an instance of {@link ForceLiquidationRecordParams}.
	 */
	public ForceLiquidationRecordParams() {
		this(null);
	}

}
