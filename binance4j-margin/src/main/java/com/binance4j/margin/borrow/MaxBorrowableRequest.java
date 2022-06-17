package com.binance4j.margin.borrow;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MaxBorrowableRequest extends FramedRequest {
    private String asset;
    private String isolatedSymbol;

    public MaxBorrowableRequest(String asset) {
        super(50);
        this.asset = asset;
    }
}
