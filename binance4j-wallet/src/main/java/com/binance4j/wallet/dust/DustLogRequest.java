package com.binance4j.wallet.dust;

import com.binance4j.core.request.IntervalRequest;

/** A request to get dust operations (assets to BNB) logs */
public class DustLogRequest extends IntervalRequest {
    /** Default constructor */
    public DustLogRequest() {
        super(1);
    }
}
