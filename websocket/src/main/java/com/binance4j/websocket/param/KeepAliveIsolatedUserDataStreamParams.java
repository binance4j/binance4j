package com.binance4j.websocket.param;

import com.binance4j.core.param.Params;
import com.binance4j.websocket.client.UserDataClient;

/**
 * {@link UserDataClient#keepAliveIsolatedUserDataStream} params.
 * 
 * @param symbol    Symbol.
 * @param listenKey Listen key.
 */
public record KeepAliveIsolatedUserDataStreamParams(String symbol, String listenKey) implements Params {
}