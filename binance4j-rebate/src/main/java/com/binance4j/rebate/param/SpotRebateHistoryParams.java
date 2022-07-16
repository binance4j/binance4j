package com.binance4j.rebate.param;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpotRebateHistoryParams extends IntervalParams {
    private Integer page = 1;

    public SpotRebateHistoryParams() {
        super(3000);
    }

    public SpotRebateHistoryParams(Integer page) {
        this();
        this.page = page;
    }
}
