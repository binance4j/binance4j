package com.binance4j.wallet.tradefee;

import com.binance4j.core.request.FramedRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

/** A request to get the fees of a trading pair */
@Data
@EqualsAndHashCode(callSuper = true)
public class TradeFeeRequest extends FramedRequest {
    /**
     * The trading pair we want the fees
     */
    private String symbol;

    public TradeFeeRequest() {
        super(1);
    }

    public TradeFeeRequest(String symbol) {
        this();
        this.symbol = symbol;
    }
}
