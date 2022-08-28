package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;
import com.binance4j.wallet.client.WalletClient;

/**
 * {@link WalletClient#getAssetDividendRecord} params.
 * 
 * @param asset Asset.
 */
@Param(weight = 10)
public record AssetDividendRecordParams(String asset) implements Params {

}