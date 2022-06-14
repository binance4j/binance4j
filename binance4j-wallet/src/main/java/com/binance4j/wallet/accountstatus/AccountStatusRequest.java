package com.binance4j.wallet.accountstatus;

import com.binance4j.core.request.FramedRequest;

/** A request to get the account status */
public class AccountStatusRequest extends FramedRequest {
    /** Constructor */
    public AccountStatusRequest() {
        super(1);
    }
}
