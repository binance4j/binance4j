package com.binance4j.websocket.dto;

/**
 * Net asset value event.
 * 
 * @param eventName Event name.
 * @param eventTime Event time.
 * @param name      BLVT name.
 * @param candle    BLVT candle.
 */
public record BLVTCandleEvent(String e, long E, String s, BLVTCandle k) {
}