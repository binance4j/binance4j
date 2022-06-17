package com.binance4j.margin.symbol;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginSymbol {
    private long id;
    private String symbol;
    private String base;
    private String quote;
    private Boolean isMarginTrade;
    private Boolean isBuyAllowed;
    private Boolean isSellAllowed;
}