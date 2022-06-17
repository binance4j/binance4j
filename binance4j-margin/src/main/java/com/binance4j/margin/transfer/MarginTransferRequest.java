package com.binance4j.margin.transfer;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferRequest extends FramedRequest {
    /** The asset being transferred, e.g., BTC */
    private String asset;
    /** The amount to be transferred */
    private BigDecimal amount;
    /**
     * 1: transfer from main account to cross margin account
     * 2: transfer from cross margin account to main account
     */
    private int type;

    public MarginTransferRequest(String asset, BigDecimal amount, MarginTransferType type) {
        super(600);
        this.asset = asset;
        this.amount = amount;
        this.type = type.getValue();
    }
}