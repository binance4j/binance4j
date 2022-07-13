package com.binance4j.margin.loan;

import com.binance4j.core.param.IntervalParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class LoanRecordParams extends IntervalParams {
    private String asset;
    /** isolated symbol */
    private String isolatedSymbol;
    /** the tranId in POST /sapi/v1/margin/loan */
    private long txId;
    /** Currently querying page. Start from 1. Default:1 */
    private long current = 1;
    /** Default:10 Max:100 */
    private long size;
    /** Set to true for archived data from 6 months ago */
    private Boolean archived;

    public LoanRecordParams(String asset) {
        super(10);
        this.asset = asset;
    }
}
