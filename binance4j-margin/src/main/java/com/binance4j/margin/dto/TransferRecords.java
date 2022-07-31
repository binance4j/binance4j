package com.binance4j.margin.dto;

import java.util.List;

/**
 * A list of transfer history records
 * 
 * @param total The total of records.
 * @param rows  The records.
 */
public record TransferRecords(int total, List<TransferRecord> rows) {
}