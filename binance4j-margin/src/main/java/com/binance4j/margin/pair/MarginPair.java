package com.binance4j.margin.pair;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginPair {
    private Long id;
    private String symbol;
    private String base;
    private String quote;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Boolean isMarginTrade;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Boolean isBuyAllowed;
    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    private Boolean isSellAllowed;

    public Boolean isMarginTrade() {
        return isMarginTrade;
    }

    public void isMarginTrade(boolean isMarginTrade) {
        this.isMarginTrade = isMarginTrade;
    }

    public Boolean isBuyAllowed() {
        return isBuyAllowed;
    }

    public void isBuyAllowed(boolean isBuyAllowed) {
        this.isBuyAllowed = isBuyAllowed;
    }

    public Boolean isSellAllowed() {
        return isSellAllowed;
    }

    public void isSellAllowed(boolean isSellAllowed) {
        this.isSellAllowed = isSellAllowed;
    }
}
