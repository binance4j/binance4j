package com.binance4j.rebate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public record SpotRebateHistoryResponse(String status, String type, String code, RebateData data) {
}
