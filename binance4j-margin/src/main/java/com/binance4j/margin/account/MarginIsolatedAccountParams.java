package com.binance4j.margin.account;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginIsolatedAccountParams extends FramedParams {
    /** Max 5 symbols can be sent; separated by "," */
    private String symbols;

    public MarginIsolatedAccountParams() {
        super(10);
    }
}