package com.binance4j.fiat.dto;

import java.util.List;

/**
 * Transaction history.
 * 
 * @param code    Code.
 * @param message Message.
 * @param data    Transactions.
 * @param total   Total.
 * @param success Success.
 */
public record PaymentHistory(String code, String message, List<Payment> data, int total, boolean success) {
}
