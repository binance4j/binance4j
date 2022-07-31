package com.binance4j.pay.dto;

import java.util.List;

/**
 * A pay trade history.
 * 
 * @param code    Response code.
 * @param message Response message.
 * @param data    The trades.
 * @param success Resposne success.
 */
public record TradeHistory(String code, String message, List<Trade> data, boolean success) {
}
