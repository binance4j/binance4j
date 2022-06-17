package com.binance4j.margin.interest;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class InterestRateHistoryRequest extends IntervalRequest {
    private String asset;
    private Integer vipLevel;

    public InterestRateHistoryRequest(String asset) {
        super(1);
        this.asset = asset;
    }
}
