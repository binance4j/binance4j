package com.binance4j.margin.fee;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CrossMarginFeeRequest extends FramedRequest {
    private final String coin;
    private Integer vipLevel;

    public CrossMarginFeeRequest() {
        super(5);
        coin = null;
    }

    public CrossMarginFeeRequest(String coin) {
        super(1);
        this.coin = coin;
    }
}
