package com.binance4j.websocket.dto;

import com.binance4j.core.dto.CandlestickInterval;

/**
 * Net asset value candle.
 * 
 * @param startTime     Start time.
 * @param endTime       End time.
 * @param name          Name.
 * @param interval      Interval.
 * @param firstUpdate   First update.
 * @param lastUpdate    Last update.
 * @param open          Open.
 * @param close         Close.
 * @param high          High.
 * @param low           Low.
 * @param realLeverage  Real leverage.
 * @param updateNumbers Number of updates.
 */
public record BLVTCandle(long t, long T, String s, CandlestickInterval i, long f, long L, String o, String c, String h, String l, String v, long n
) {
}
