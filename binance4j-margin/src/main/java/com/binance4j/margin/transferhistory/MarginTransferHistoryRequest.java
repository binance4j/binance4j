package com.binance4j.margin.transferhistory;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferHistoryRequest extends IntervalRequest {
    private String asset;
    private MarginTransferHistoryType type;
    private long current;
    private int size;
    private Boolean archived;

    public MarginTransferHistoryRequest() {
        super(1);
    }
}