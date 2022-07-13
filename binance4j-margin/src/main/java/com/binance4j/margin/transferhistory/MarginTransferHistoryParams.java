package com.binance4j.margin.transferhistory;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferHistoryParams extends IntervalParams {
    private String asset;
    private MarginTransferHistoryType type;
    private Long current;
    private Integer size;
    private Boolean archived;

    public MarginTransferHistoryParams() {
        super(1);
    }
}