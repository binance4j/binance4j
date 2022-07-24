package com.binance4j.portfoliomargin.dto;

import java.math.BigDecimal;

/** Margin portfolio account infos */
public record AccountInfo(
		/** Portfolio margin account maintenance margin rate. */
		BigDecimal uniMMR,
		/** Account equity, unit：USD. */
		BigDecimal accountEquity,
		/** Portfolio margin account maintenance margin, unit：USD */
		BigDecimal accountMaintMargin,
		/**
		 * Portfolio margin account status.
		 * <p>
		 * Enum: NORMAL, MARGIN_CALL, SUPPLY_MARGIN, REDUCE_ONLY, ACTIVE_LIQUIDATION, FORCE_LIQUIDATION, BANKRUPTED
		 */
		String accountStatus) {
}
