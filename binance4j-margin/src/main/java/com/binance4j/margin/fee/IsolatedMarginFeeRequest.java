package com.binance4j.margin.fee;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class IsolatedMarginFeeRequest extends FramedRequest {
    private final String symbol;
    private Integer vipLevel;

    public IsolatedMarginFeeRequest() {
        super(10);
        symbol = null;
    }

    public IsolatedMarginFeeRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
