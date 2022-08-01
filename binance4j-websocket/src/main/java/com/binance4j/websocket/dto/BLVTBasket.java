package com.binance4j.websocket.dto;

/**
 * Net asset value basket.
 * 
 * @param symbol   Futures symbol.
 * @param position Position.
 */
public record BLVTBasket(String s, long n) {
}
