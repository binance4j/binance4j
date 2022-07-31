package com.binance4j.margin.dto;

/**
 * Max Borrowable amount.
 * 
 * @param amount      Account's currently max borrowable amount with sufficient system availability.
 * @param borrowLimit Max borrowable amount limited by the account level.
 */
public record MaxBorrowable(String amount, String borrowLimit) {
}