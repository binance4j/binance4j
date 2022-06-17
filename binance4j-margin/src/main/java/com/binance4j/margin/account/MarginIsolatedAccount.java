package com.binance4j.margin.account;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginIsolatedAccount {
    private List<MarginIsolatedAssets> assets;
    private BigDecimal totalAssetOfBtc;
    private BigDecimal totalLiabilityOfBtc;
    private BigDecimal totalNetAssetOfBtc;
}
