package com.binance4j.margin.transfer;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginIsolatedTransferRequest extends FramedRequest {
    private String asset;
    private String symbol;
    private MarginIsolatedTransferType transFrom;
    private MarginIsolatedTransferType transTo;
    private BigDecimal amount;

    public MarginIsolatedTransferRequest(String asset, String symbol, MarginIsolatedTransferType transFrom,
            MarginIsolatedTransferType transTo, BigDecimal amount) {
        super(600);
        this.asset = asset;
        this.symbol = symbol;
        this.transFrom = transFrom;
        this.transTo = transTo;
        this.amount = amount;
    }
}
