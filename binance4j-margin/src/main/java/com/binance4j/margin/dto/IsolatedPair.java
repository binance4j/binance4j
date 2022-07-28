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
public record IsolatedPair(
		/** The base asset. */
		IsolatedAsset baseAsset,
		/** The quote asset. */
		IsolatedAsset quoteAsset,
		/** The asset symbol. */
		String symbol,
		/** is isolated asset created */
		boolean isolatedCreated,
		/** Is trading enabled? */
		boolean tradeEnabled,
		/** Is the pair enabled for the account? */
		boolean enabled,
		/**
		 * The margin level status.
		 * 
		 * @see LevelStatus
		 */
		String marginLevelStatus,
		/** The margin level. */
		String marginLevel,
		/** The margin ratio. */
		String marginRatio,
		/** The index price. */
		String indexPrice,
		/** The liquidate price. */
		String liquidatePrice,
		/** The liquidate rate. */
		String liquidateRate) {
}