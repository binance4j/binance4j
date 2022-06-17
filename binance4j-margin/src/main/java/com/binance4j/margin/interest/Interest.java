package com.binance4j.margin.interest;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Interest {
    // isolated symbol, will not be returned for crossed margin
    private String isolatedSymbol;
    private String asset;
    private long interestAccuredTime;
    private BigDecimal interest;
    private BigDecimal interestRate;
    private BigDecimal principal;
    private InterestType type;
}
