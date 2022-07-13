package com.binance4j.margin.order;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginOpenOrdersParams extends FramedParams {
    private String symbol;
    private Boolean isIsolated;

    public MarginOpenOrdersParams() {
        super(10);
    }
}
