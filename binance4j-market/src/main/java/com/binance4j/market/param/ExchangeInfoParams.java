package com.binance4j.market.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.market.client.MarketClient;

/**
 * {@link MarketClient#getExchangeInfo} params.
 * 
 * @param symbol Symbol.
 */
@Param(weight = 10, recvWindow = false, timestamp = false)
public record ExchangeInfoParams(String symbol) implements Params {
	/** Creates an instance of {@link ExchangeInfoParams}. */
	public ExchangeInfoParams() {
		this(null);
	}
}