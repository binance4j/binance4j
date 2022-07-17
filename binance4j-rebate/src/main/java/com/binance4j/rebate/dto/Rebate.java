package com.binance4j.rebate.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public record Rebate(String asset, RebateType type, BigDecimal amount, Long updateTime) {
}
