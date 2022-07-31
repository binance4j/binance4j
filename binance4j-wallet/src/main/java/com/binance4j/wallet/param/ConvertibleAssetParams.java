package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getConvertibleAssets} params.
 */
@Param
public record ConvertibleAssetParams() implements Params {
}