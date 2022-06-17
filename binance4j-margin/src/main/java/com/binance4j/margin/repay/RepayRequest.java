package com.binance4j.margin.repay;

import java.math.BigDecimal;

import com.binance4j.core.request.FramedRequest;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@EqualsAndHashCode(callSuper = true)
public class RepayRequest extends FramedRequest {
    /** Asset to repay */
    private String asset;
    /** Isolated symbol */
    private String symbol;
    /** For isolated margin or not, "TRUE", "FALSE"，default "FALSE" */
    @Setter(value = AccessLevel.NONE)
    private Boolean isIsolated;
    /** Amount to repay */
    private BigDecimal amount;

    public RepayRequest(String asset, BigDecimal amount) {
        super(300);
        this.asset = asset;
        this.amount = amount;
    }

    /**
     * Isolated margin repay
     * 
     * @param symbol isolated symbol
     */
    public void isIsolated(String symbol) {
        this.isIsolated = true;
        this.symbol = symbol;
    }

    /** Crossed margin repay */
    public void isNotIsolated() {
        this.isIsolated = false;
        this.symbol = null;
    }
}