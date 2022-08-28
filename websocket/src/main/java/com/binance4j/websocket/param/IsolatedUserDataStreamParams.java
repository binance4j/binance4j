package com.binance4j.websocket.param;

import com.binance4j.core.param.Params;
import com.binance4j.websocket.client.UserDataClient;

/**
 * {@link UserDataClient#startIsolatedUserDataStream} params.
 * 
 * @param symbol Symbol.
 */
public record IsolatedUserDataStreamParams(String symbol) implements Params {
}
