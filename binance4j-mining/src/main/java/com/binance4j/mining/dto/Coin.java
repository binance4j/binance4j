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
public record Coin(String coinName, long coinId, long poolIndex, long algoId, String algoName) {
}
