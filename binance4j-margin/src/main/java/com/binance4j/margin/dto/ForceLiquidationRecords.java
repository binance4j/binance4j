package com.binance4j.margin.dto;

import java.util.List;

/**
 * A {@link ForceLiquidationRecord} records container
 * 
 * @param rows  The records.
 * @param total The total number of records.
 */
public record ForceLiquidationRecords(List<ForceLiquidationRecord> rows, int total) {
}