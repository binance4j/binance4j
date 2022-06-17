package com.binance4j.margin.account;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ToogleAccountRequest extends FramedRequest {
    private String symbol;

    public ToogleAccountRequest(String symbol) {
        super(300);
        this.symbol = symbol;
    }
}
