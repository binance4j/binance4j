package com.binance4j.margin.param;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BNBBurnStatus(Boolean spotBNBBurn, Boolean interestBNBBurn) {
}