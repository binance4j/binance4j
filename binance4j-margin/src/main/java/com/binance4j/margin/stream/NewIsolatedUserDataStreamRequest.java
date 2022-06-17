package com.binance4j.margin.stream;

import com.binance4j.core.request.Request;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewIsolatedUserDataStreamRequest extends Request {
    private String symbol;

    public NewIsolatedUserDataStreamRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
