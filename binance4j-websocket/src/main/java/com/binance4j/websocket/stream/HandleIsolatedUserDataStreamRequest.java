package com.binance4j.websocket.stream;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HandleIsolatedUserDataStreamRequest extends NewIsolatedUserDataStreamRequest {
    private String listenKey;

    public HandleIsolatedUserDataStreamRequest(String symbol, String listenKey) {
        super(symbol);
        this.listenKey = listenKey;
    }
}
