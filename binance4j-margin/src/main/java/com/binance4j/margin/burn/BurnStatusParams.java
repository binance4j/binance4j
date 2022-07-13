package com.binance4j.margin.burn;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BurnStatusParams extends FramedParams {
    public BurnStatusParams() {
        super(1);
    }
}