package com.binance4j.margin.account;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginIsolatedAccountLimitRequest extends FramedRequest {
    public MarginIsolatedAccountLimitRequest() {
        super(1);
    }
}
