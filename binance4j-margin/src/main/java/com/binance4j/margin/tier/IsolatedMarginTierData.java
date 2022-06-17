package com.binance4j.margin.tier;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class IsolatedMarginTierData {
    private String symbol;
    private int tier;
    private BigDecimal effectiveMultiple;
    private BigDecimal initialRiskRatio;
    private BigDecimal liquidationRiskRatio;
    private BigDecimal baseAssetMaxBorrowable;
    private BigDecimal quoteAssetMaxBorrowable;
}