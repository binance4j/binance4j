package com.binance4j.margin.dto;

import java.util.List;

/**
 * Isolated margin transfer records
 * 
 * @param rows  The transfers.
 * @param total The total records.
 */
public record IsolatedTransferRecords(List<IsolatedTransferRecord> rows, int total) {
}