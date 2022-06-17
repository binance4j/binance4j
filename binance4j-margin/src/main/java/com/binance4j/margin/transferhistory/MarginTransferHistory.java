package com.binance4j.margin.transferhistory;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTransferHistory {
    private BigDecimal amount;
    private String asset;
    private String status;
    private long timestamp;
    private long txId;
    private MarginTransferHistoryType type;
}