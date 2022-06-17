package com.binance4j.margin.account;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.margin.balance.MarginAssetBalance;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginAccount {
    private Boolean borrowEnabled;
    private Boolean tradeEnabled;
    private Boolean transferEnabled;
    private BigDecimal marginLevel;
    private BigDecimal totalAssetOfBtc;
    private BigDecimal totalLiabilityOfBtc;
    private BigDecimal totalNetAssetOfBtc;
    private List<MarginAssetBalance> userAssets;
}