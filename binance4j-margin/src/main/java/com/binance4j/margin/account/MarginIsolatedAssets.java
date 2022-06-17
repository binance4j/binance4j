package com.binance4j.margin.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginIsolatedAssets {
    private MarginIsolatedAsset baseAsset;
    private MarginIsolatedAsset quoteAsset;
    private String symbol;
    private Boolean isolatedCreated;
    private Boolean tradeEnabled;
    private Boolean enabled;
    private MarginLevelStatus marginLevelStatus;
    private BigDecimal marginLevel;
    private BigDecimal marginRatio;
    private BigDecimal indexPrice;
    private BigDecimal liquidatePrice;
    private BigDecimal liquidateRate;
}