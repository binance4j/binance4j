package com.binance4j.margin.transfer;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferHistoryParams extends IntervalParams {
    private String asset;
    private String symbol;
    private MarginIsolatedTransferType transFrom;
    private MarginIsolatedTransferType transTo;
    /** Current page,default 1 */
    private Long current;
    /** Default 10, max 100 */
    private int size;

    public MarginTransferHistoryParams(String symbol) {
        super(1);
        this.symbol = symbol;
    }
}
