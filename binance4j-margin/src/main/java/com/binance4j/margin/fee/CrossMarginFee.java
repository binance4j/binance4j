package com.binance4j.margin.fee;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CrossMarginFee {
    private int vipLevel;
    private String coin;
    private Boolean transferIn;
    private Boolean borrowable;
    private BigDecimal dailyInterest;
    private BigDecimal yearlyInterest;
    private BigDecimal borrowLimit;
    private List<String> marginablePairs;
}
