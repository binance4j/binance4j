package com.binance4j.margin.asset;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAsset {
    private String assetFullName;
    private String assetName;
    private Boolean isBorrowable;
    private Boolean isMortgageable;
    private BigDecimal userMinBorrow;
    private BigDecimal userMinRepay;
}
