package com.binance4j.wallet.param;

import com.binance4j.core.annotation.Param;
import com.binance4j.core.param.Params;

/** The parameters to get dust operations (assets to BNB) logs */
@Param
public record DustLogParams() implements Params {
}
