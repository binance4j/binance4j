package com.binance4j.margin.dto;

import java.util.List;

/**
 * A loan record.
 * 
 * @param totalclas The total records.
 * @param rowsclas  The records.
 */
public record LoanRecord(int totalclas, List<Loan> rowsclas) {
}