package com.binance4j.margin.oco;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetOpenMarginOCORequest extends FramedRequest {
    private Boolean isIsolated;
    /** mandatory for isolated margin, not supported for cross margin */
    private String symbol;

    public GetOpenMarginOCORequest() {
        super(10);
    }
}
