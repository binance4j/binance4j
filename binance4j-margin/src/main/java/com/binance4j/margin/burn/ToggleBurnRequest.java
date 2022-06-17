package com.binance4j.margin.burn;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToggleBurnRequest extends FramedRequest {
    /** Determines whether to use BNB to pay for trading fees on SPOT */
    private Boolean spotBNBBurn;
    /** Determines whether to use BNB to pay for margin loan's interest */
    private Boolean interestBNBBurn;

    public ToggleBurnRequest() {
        super(1);
    }
}