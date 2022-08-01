package com.binance4j.mining.dto;

/**
 * Account statistics
 * 
 * @param time     Time in ms.
 * @param hashrate Hashrate.
 * @param reject   Reject rate.
 */
public record AccountList(long time, String hashrate, String reject) {
}
