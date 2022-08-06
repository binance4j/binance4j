package com.binance4j.wallet.param;

import java.util.List;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.dto.RateLimitType;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#dustTransfert} params.
 * 
 * @param assets List of assets to convert into BNB.
 */
@Param(weight = 10, type = RateLimitType.UID)
public record DustTransferParams(List<String> assets) implements Params {
}