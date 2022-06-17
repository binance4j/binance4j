package com.binance4j.margin.account;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginIsolatedAsset {
    private String asset;
    private Boolean borrowEnabled;
    private Boolean repayEnabled;
    private BigDecimal borrowed;
    private BigDecimal free;
    private BigDecimal interest;
    private BigDecimal locked;
    private BigDecimal netAsset;
    private BigDecimal netAssetOfBtc;
    private BigDecimal totalAsset;
}
