package com.binance4j.margin.transfer;

import java.math.BigDecimal;

import com.binance4j.core.param.FramedParams;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MarginTransferParams extends FramedParams {
    /** The asset being transferred, e.g., BTC */
    private String asset;
    /** The amount to be transferred */
    private BigDecimal amount;
    /**
     * The transfer type
     * <p>
     * 1: transfer from main account to cross margin account
     * <p>
     * 2: transfer from cross margin account to main account
     */
    private int type;

    /**
     * Constructor
     * 
     * @param asset  The asset to transfer
     * @param amount The amout to transfer
     * @param type   The transfer type
     */
    public MarginTransferParams(String asset, BigDecimal amount, MarginTransferType type) {
        super(600);
        this.asset = asset;
        this.amount = amount;
        this.type = type.getValue();
    }

    /**
     * Constructor
     * 
     * @param asset  The asset to transfer
     * @param amount The amout to transfer
     * @param type   The transfer type. 1: transfer from main account to cross
     *               margin account, 2: transfer from cross margin account to main
     *               account
     */
    public MarginTransferParams(String asset, BigDecimal amount, int type) {
        super(600);
        this.asset = asset;
        this.amount = amount;
        this.type = type;
    }
}