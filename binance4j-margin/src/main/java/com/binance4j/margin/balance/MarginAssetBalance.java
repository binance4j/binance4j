package com.binance4j.margin.balance;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * An asset balance in an Account.
 */
@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAssetBalance {
    private String asset;
    private BigDecimal borrowed;
    private BigDecimal free;
    private BigDecimal interest;
    private BigDecimal locked;
    private BigDecimal netAsset;
}