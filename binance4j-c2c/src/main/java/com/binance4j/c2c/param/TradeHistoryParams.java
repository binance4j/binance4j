package com.binance4j.c2c.param;

import com.binance4j.c2c.client.C2CClient;
import com.binance4j.c2c.dto.TradeType;
import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link C2CClient#getTrades} params.
 * 
 * @param tradeType Trade type.
 */
@Param
public record TradeHistoryParams(@Mandatory TradeType tradeType) implements Params {
}