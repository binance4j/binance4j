package com.binance4j.wallet.param;

import java.util.List;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;

/**
 * The parameters to convert small volumes (dust) into BNB.
 * 
 * @param assets The list of assets to convert into BNB.
 */
@Param(weight = 10, type = RateLimitType.UID)
public record DustTransferParams(@Mandatory List<String> assets) implements Params {
}