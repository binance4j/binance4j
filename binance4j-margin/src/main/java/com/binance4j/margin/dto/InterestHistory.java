package com.binance4j.margin.dto;

import java.util.List;

/**
 * Interest History containing {@link InterestRecord InterestRecords}
 * 
 * @param total The total number of records.
 * @param rows  The interest records.
 */
public record InterestHistory(int total, List<InterestRecord> rows) {
}