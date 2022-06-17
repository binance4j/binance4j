package com.binance4j.margin.account;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginIsolatedAccountRequest extends FramedRequest {
    /** Max 5 symbols can be sent; separated by "," */
    private String symbols;

    public MarginIsolatedAccountRequest() {
        super(10);
    }
}