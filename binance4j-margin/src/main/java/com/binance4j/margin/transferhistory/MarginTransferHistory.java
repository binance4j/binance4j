package com.binance4j.margin.transferhistory;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTransferHistory {
    private BigDecimal amount;
    private String asset;
    private String status;
    private Long timestamp;
    @JsonProperty("txId")
    private Long transactionId;
    private MarginTransferHistoryType type;
}