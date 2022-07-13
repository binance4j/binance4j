package com.binance4j.websocket.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KeepAliveIsolatedUserDataStreamParams extends IsolatedUserDataStreamParams {
    private String listenKey;

    public KeepAliveIsolatedUserDataStreamParams(String symbol, String listenKey) {
        super(symbol);
        this.listenKey = listenKey;
    }
}
