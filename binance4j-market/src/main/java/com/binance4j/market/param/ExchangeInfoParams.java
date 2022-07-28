package com.binance4j.market.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * The parameters to retrieve the exchange trading rules and symbol information.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 10, recvWindow = false, timestamp = false)
public record ExchangeInfoParams(@Mandatory String symbol) implements Params {
	/** Creates an instance of {@link ExchangeInfoParams}. */
	public ExchangeInfoParams() {
		this(null);
	}
}