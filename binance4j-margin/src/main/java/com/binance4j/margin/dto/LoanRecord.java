package com.binance4j.margin.dto;

import java.util.List;

/**
 * A loan record.
 * 
 * @param total The total records.
 * @param rows  The records.
 */
public record LoanRecord(int total, List<Loan> rows) {
}