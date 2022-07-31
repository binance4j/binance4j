package com.binance4j.portfoliomargin.dto;

/** Margin portfolio account infos */
public record AccountInfo(String uniMMR, String accountEquity, String accountMaintMargin,
		/**
		 * Portfolio margin account status.
		 * <p>
		 * Enum: NORMAL, MARGIN_CALL, SUPPLY_MARGIN, REDUCE_ONLY, ACTIVE_LIQUIDATION, FORCE_LIQUIDATION, BANKRUPTED
		 */
		String accountStatus) {
}
