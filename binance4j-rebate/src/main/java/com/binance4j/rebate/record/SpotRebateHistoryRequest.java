package com.binance4j.rebate.record;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SpotRebateHistoryRequest extends IntervalRequest {
    private Integer page = 1;

    public SpotRebateHistoryRequest() {
        super(3000);
    }

    public SpotRebateHistoryRequest(Integer page) {
        this();
        this.page = page;
    }
}
