package com.binance4j.margin.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.margin.client.MarginClient;

/** {@link MarginClient#getEnabledIsolatedAccountLimit} params. */
@Param
public record IsolatedAccountLimitParams() implements Params {
}