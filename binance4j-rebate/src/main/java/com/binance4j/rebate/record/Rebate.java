package com.binance4j.rebate.record;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Rebate {
    private String asset;
    private RebateType type;
    private BigDecimal amount;
    private Long updateTime;
}
