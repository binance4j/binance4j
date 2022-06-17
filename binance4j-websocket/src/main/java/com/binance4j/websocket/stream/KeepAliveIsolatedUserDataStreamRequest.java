package com.binance4j.websocket.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class KeepAliveIsolatedUserDataStreamRequest extends IsolatedUserDataStreamRequest {
    private String listenKey;

    public KeepAliveIsolatedUserDataStreamRequest(String symbol, String listenKey) {
        super(symbol);
        this.listenKey = listenKey;
    }
}
