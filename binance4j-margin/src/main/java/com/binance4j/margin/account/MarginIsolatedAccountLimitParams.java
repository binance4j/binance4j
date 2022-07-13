package com.binance4j.margin.account;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginIsolatedAccountLimitParams extends FramedParams {
    public MarginIsolatedAccountLimitParams() {
        super(1);
    }
}
