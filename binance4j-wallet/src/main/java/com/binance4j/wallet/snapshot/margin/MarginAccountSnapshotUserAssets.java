package com.binance4j.wallet.snapshot.margin;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccountSnapshotUserAssets {
    /**
     * The asset abbreviation
     * 
     * 
     **/
    private String asset;
    /**
     * The borrowed amount
     * 
     * 
     **/
    private BigDecimal borrowed;
    /**
     * The fee amount
     * 
     * 
     **/
    private BigDecimal free;
    /**
     * The interest amount
     * 
     * 
     **/
    private BigDecimal interest;
    /**
     * The locked volume
     * 
     * 
     **/
    private BigDecimal locked;
    /**
     * ???
     * 
     * 
     **/
    private BigDecimal netAsset;
}