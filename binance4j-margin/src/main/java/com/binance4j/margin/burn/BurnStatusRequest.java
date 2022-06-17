package com.binance4j.margin.burn;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BurnStatusRequest extends FramedRequest {
    public BurnStatusRequest() {
        super(1);
    }
}