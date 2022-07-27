package com.binance4j.portfoliomargin.dto;

/** Margin portfolio account infos */
public record AccountInfo(
		/** Portfolio margin account maintenance margin rate. */
		String uniMMR,
		/** Account equity, unit：USD. */
		String accountEquity,
		/** Portfolio margin account maintenance margin, unit：USD */
		String accountMaintMargin,
		/**
		 * Portfolio margin account status.
		 * <p>
		 * Enum: NORMAL, MARGIN_CALL, SUPPLY_MARGIN, REDUCE_ONLY, ACTIVE_LIQUIDATION, FORCE_LIQUIDATION, BANKRUPTED
		 */
		String accountStatus) {
}
