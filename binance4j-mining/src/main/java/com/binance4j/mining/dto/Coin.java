package com.binance4j.mining.dto;

/**
 * A mineable coin.
 * 
 * @param coinName  The currency name.
 * @param coinId    The coin id.
 * @param poolIndex The pool index.
 * @param algoId    The algorithm id.
 * @param algoName  The name of the algorithm.
 */
public record Coin(
		/** The currency name. */
		String coinName,
		/** The coin id. */
		long coinId,
		/** The pool index. */
		long poolIndex,
		/** The algorithm id. */
		long algoId,
		/** The name of the algorithm. */
		String algoName) {
}
