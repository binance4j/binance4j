package com.binance4j.blvt.param;

import com.binance4j.blvt.client.BLVTClient;
import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/**
 * {@link BLVTClient#redeem} params.
 * 
 * @param tokenName The token name.
 * @param amount    Amount to redeem.
 */
@Param
public record RedemptionParams(@Mandatory String tokenName, @Mandatory String amount) implements Params {
}