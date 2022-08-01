package com.binance4j.margin.dto;

/**
 * Isolated asset pair in an {@link IsolatedAccount}
 * 
 * @param baseAsset         The base asset.
 * @param quoteAsset        The quote asset.
 * @param symbol            The asset symbol.
 * @param isolatedCreated   is isolated asset created.
 * @param tradeEnabled      Is trading enabled?
 * @param enabled           Is the pair enabled for the account?
 * @param marginLevelStatus The margin level status.
 * @param marginLevel       The margin level.
 * @param marginRatio       The margin ratio.
 * @param indexPrice        The index price.
 * @param liquidatePrice    The liquidate price.
 * @param liquidateRate     The liquidate rate.
 * @see LevelStatus
 */
public record IsolatedPair(IsolatedAsset baseAsset, IsolatedAsset quoteAsset, String symbol, boolean isolatedCreated, boolean tradeEnabled, boolean enabled,
		String marginLevelStatus, String marginLevel, String marginRatio, String indexPrice, String liquidatePrice, String liquidateRate) {
}