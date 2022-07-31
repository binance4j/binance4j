package com.binance4j.websocket.param;

import com.binance4j.core.annotation.Mandatory;
import com.binance4j.core.param.Params;
import com.binance4j.websocket.client.UserDataClient;

/**
 * {@link UserDataClient#startIsolatedUserDataStream} params.
 * 
 * @param symbol The symbol.
 */
public record IsolatedUserDataStreamParams(@Mandatory String symbol) implements Params {
}
