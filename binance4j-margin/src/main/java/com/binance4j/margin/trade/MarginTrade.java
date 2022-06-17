package com.binance4j.margin.trade;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTrade {
    private BigDecimal commission;
    private String commissionAsset;
    private long id;
    private Boolean isBestMatch;
    private Boolean isBuyer;
    private Boolean isMaker;
    private long orderId;
    private BigDecimal price;
    private BigDecimal qty;
    private String symbol;
    private Boolean isIsolated;
    private long time;
}