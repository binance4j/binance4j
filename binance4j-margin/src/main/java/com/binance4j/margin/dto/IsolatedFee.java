package com.binance4j.margin.dto;

import java.util.List;

/**
 * Isolated margin fee
 * 
 * @param vipLevel The VIP level.
 * @param symbol   The related symbol.
 * @param leverage The leverage.
 * @param data     The isolated fee data.
 */
public record IsolatedFee(int vipLevel, String symbol, String leverage, List<IsolatedFeeData> data) {
}