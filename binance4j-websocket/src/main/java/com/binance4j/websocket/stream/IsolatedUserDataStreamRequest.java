package com.binance4j.websocket.stream;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedUserDataStreamRequest extends Request {
    private String symbol;

    public IsolatedUserDataStreamRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
