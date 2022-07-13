package com.binance4j.margin.priceindex;

import com.binance4j.core.param.Params;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PriceIndexParams extends Params {
    private String symbol;

    public PriceIndexParams(String symbol) {
        super(10);
        this.symbol = symbol;
    }
}
