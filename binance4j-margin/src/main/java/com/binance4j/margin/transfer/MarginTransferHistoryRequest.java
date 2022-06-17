package com.binance4j.margin.transfer;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferHistoryRequest extends IntervalRequest {
    private String asset;
    private String symbol;
    private MarginIsolatedTransferType transFrom;
    private MarginIsolatedTransferType transTo;
    private Long startTime;
    private Long endTime;
    /** Current page,default 1 */
    private Long current;
    /** Default 10, max 100 */
    private int size;

    public MarginTransferHistoryRequest(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
