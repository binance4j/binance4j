package com.binance4j.margin.borrow;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = true)
public class BorrowRequest extends FramedRequest {
    /** Asset to borrow */
    private String asset;
    /** Isolated symbol */
    private String symbol;
    /** For isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
    @Setter(value = AccessLevel.NONE)
    private Boolean isIsolated;
    /** Amount to borrow */
    private BigDecimal amount;

    public BorrowRequest(String asset, BigDecimal amount) {
        super(300);
        this.asset = asset;
        this.amount = amount;
    }

    /**
     * Isolated margin loan
     * 
     * @param symbol isolated symbol
     */
    public void isIsolated(String symbol) {
        this.isIsolated = true;
        this.symbol = symbol;
    }

    /** Crossed margin loan */
    public void isNotIsolated() {
        this.isIsolated = false;
        this.symbol = null;
    }
}