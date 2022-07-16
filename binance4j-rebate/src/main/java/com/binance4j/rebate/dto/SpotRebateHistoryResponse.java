package com.binance4j.rebate.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SpotRebateHistoryResponse {
    private String status;
    private String type;
    private String code;
    private RebateData data;
}
