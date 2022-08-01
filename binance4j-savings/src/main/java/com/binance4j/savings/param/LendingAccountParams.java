package com.binance4j.savings.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.savings.client.SavingsClient;

/** {@link SavingsClient#getAccount} params. */
@Param
public record LendingAccountParams() implements Params {
}