package com.binance4j.margin.forceliquidation;

import com.binance4j.core.request.IntervalRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ForceLiquidationRecordRequest extends IntervalRequest {
    /** isolated symbol */
    private String isolatedSymbol;
    /** Currently querying page. Start from 1. Default:1 */
    private long current;
    /** Default:10 Max:100 */
    private long size;

    public ForceLiquidationRecordRequest() {
        super(1);
    }
}
