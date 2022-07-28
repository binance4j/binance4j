package com.binance4j.mining.dto;

/**
 * A mining algorithm.
 * 
 * @param algoName  The algorithm name.
 * @param algoID    The algorithm id.
 * @param poolIndex The sequence.
 * @param unit      The unit.
 */
public record Algorithm(
		/** The algorithm name. */
		String algoName,
		/** The algorithm id. */
		long algoId,
		/** The sequence. */
		long poolIndex,
		/** The unit. */
		String unit) {
}
