package com.binance4j.mining.dto;

/**
 * A mining algorithm.
 * 
 * @param algoName  Algorithm name.
 * @param algoId    Algorithm id.
 * @param poolIndex Sequence.
 * @param unit      Unit.
 */
public record Algorithm(String algoName, long algoId, long poolIndex, String unit) {
}
