package com.binance4j.mining.dto;

/**
 * A miner/worker data.
 * 
 * @param workerId      The miner id.
 * @param workerName    The miner's name'.
 * @param status        Status：1 valid, 2 invalid, 3 no longer valid.
 * @param hashRate      Real-time rate.
 * @param dayHashRate   24H Hashrate.
 * @param rejectRate    Real-time Rejection Rate.
 * @param lastShareTime Last submission time.
 */
public record Worker(String workerId, String workerName, long status, long hashRate, long dayHashRate, long rejectRate, long lastShareTime) {
}