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
public record Miner(
		/** The miner id. */
		String workerId,
		/** The miner's name'. */
		String workerName,
		/** Status：1 valid, 2 invalid, 3 no longer valid. */
		long status,
		/** Real-time rate. */
		long hashRate,
		/** 24H Hashrate. */
		long dayHashRate,
		/** Real-time Rejection Rate. */
		long rejectRate,
		/** Last submission time. */
		long lastShareTime) {
}