package com.binance4j.c2c.dto;

import java.util.List;

/**
 * C2C trades history.
 * 
 * @param code    Code.
 * @param message Message.
 * @param data    Trades.
 * @param total   Total.
 * @param success Success.
 */
public record TradeHistory(String code, String message, List<Trade> data, int total, boolean success) {
}
