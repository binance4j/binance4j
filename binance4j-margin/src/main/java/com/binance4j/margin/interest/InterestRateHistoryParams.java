package com.binance4j.margin.interest;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InterestRateHistoryParams extends IntervalParams {
    private String asset;
    private Integer vipLevel;

    public InterestRateHistoryParams(String asset) {
        super(1);
        this.asset = asset;
    }
}
