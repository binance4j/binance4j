package com.binance4j.margin.burn;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToggleBurnParams extends FramedParams {
    /** Determines whether to use BNB to pay for trading fees on SPOT */
    private Boolean spotBNBBurn;
    /** Determines whether to use BNB to pay for margin loan's interest */
    private Boolean interestBNBBurn;

    /** Constructor */
    public ToggleBurnParams() {
        super(1);
    }

    /** Constructor */
    public ToggleBurnParams(Boolean spotBNBBurn, Boolean interestBNBBurn) {
        this();
        this.spotBNBBurn = spotBNBBurn;
        this.interestBNBBurn = interestBNBBurn;
    }
}