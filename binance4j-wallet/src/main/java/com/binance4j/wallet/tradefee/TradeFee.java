package com.binance4j.wallet.tradefee;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/** A trading pair trade fees */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeFee {
    /**
     * The trading pair
     */
    private String symbol;
    /**
     * The maker fees (limit order)
     */
    private BigDecimal makerCommission;
    /**
     * The taker fees (market order)
     */
    private BigDecimal takerCommission;
}
