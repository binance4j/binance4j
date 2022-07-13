package com.binance4j.websocket.stream;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedUserDataStreamParams extends Params {
    private String symbol;

    public IsolatedUserDataStreamParams(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
