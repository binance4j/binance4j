package com.binance4j.margin.dto;

/**
 * Isolated fee data
 * 
 * @param coin          The related coin.
 * @param dailyInterest The daily interest.
 * @param borrowLimit   The borrow limit.
 */
public record IsolatedFeeData(String coin, String dailyInterest, String borrowLimit) {
}