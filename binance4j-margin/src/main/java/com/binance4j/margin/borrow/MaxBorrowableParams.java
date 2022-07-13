package com.binance4j.margin.borrow;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MaxBorrowableParams extends FramedParams {
    private String asset;
    private String isolatedSymbol;

    public MaxBorrowableParams(String asset) {
        super(50);
        this.asset = asset;
    }
}
