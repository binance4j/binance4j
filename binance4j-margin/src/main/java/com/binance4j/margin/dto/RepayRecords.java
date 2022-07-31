package com.binance4j.margin.dto;

import java.util.List;

/**
 * A repay record.
 * 
 * @param total The total of repays.
 * @param rows  The repays.
 */
public record RepayRecords(int total, List<RepayRecord> rows) {
}