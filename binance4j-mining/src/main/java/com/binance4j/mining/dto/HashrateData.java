package com.binance4j.mining.dto;

/**
 * Hashrate data.
 * 
 * @param time     Time in ms.
 * @param hashrate Hashrate.
 * @param reject   Rejection Rate.
 */
public record HashrateData(long time, String hashrate, long reject) {
}