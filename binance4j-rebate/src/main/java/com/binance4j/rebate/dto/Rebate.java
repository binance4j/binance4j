package com.binance4j.rebate.dto;

/**
 * A rebate
 * 
 * @param asset      The rebate asset.
 * @param type       The rebate type.
 * @param amount     The rebate amount.
 * @param updateTime The rebate update time.
 * @see RebateType
 */
public record Rebate(
		/** The rebate asset */
		String asset,
		/**
		 * The rebate type.
		 * 
		 * @see RebateType
		 */
		String type,
		/** The rebate amount */
		String amount,
		/** The rebate update time */
		long updateTime) {
}
