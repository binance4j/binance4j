package com.binance4j.margin.fee;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CrossMarginFeeParams extends FramedParams {
    private final String coin;
    private Integer vipLevel;

    public CrossMarginFeeParams() {
        super(5);
        coin = null;
    }

    public CrossMarginFeeParams(String coin) {
        super(1);
        this.coin = coin;
    }
}
