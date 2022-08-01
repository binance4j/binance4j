package com.binance4j.margin.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A loan record.
 * 
 * @param total The total records.
 * @param rows  The records.
 */
public record LoanRecord(int totalclas, @JsonProperty("rowsclas") List<Loan> rows) {
}