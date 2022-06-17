package com.binance4j.margin.oco;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class GetMarginOCORequest extends FramedRequest {
    private Boolean isIsolated;
    /** mandatory for isolated margin, not supported for cross margin */
    private String symbol;
    /** Either orderListId or origClientOrderId must be provided */
    private Long orderListId;
    /** Either orderListId or origClientOrderId must be provided */
    private String origClientOrderId;

    public GetMarginOCORequest() {
        super(10);
    }
}
