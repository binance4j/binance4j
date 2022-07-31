package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** Requests assets that can be converted into BNB */
@Param
public record ConvertibleAssetParams() implements Params {
}