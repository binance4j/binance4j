package com.binance4j.websocket.dto;

/**
 * Minimal infos Ticker.
 * 
 * @param eventType                   The event type.
 * @param eventTime                   The timestamp.
 * @param symbol                      The trading pair.
 * @param closePrice                  The close price.
 * @param openPrice                   The open price.
 * @param highPrice                   The highest price.
 * @param lowPrice                    The lowest price.
 * @param totalTradedBaseAssetVolume  Total traded base asset volume.
 * @param totalTradedQuoteAssetVolume Total traded quote asset volume.
 */
public record MiniTicker(String e, Long E, String s, String c, String o, String h, String l, String v, String q) {
}