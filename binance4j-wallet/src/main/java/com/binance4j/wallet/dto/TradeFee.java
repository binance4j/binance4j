package com.binance4j.wallet.dto;

/**
 * A trading pair trade fees.
 * 
 * @param symbol          The trading pair.
 * @param makerCommission The maker fees (limit order).
 * @param takerCommission The taker fees (market order).
 */
public record TradeFee(String symbol, String makerCommission, String takerCommission) {
}
