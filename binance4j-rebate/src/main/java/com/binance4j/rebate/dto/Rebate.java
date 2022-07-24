package com.binance4j.rebate.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A rebate
 * 
 * @param asset      The rebate asset.
 * @param type       The rebate type.
 * @param amount     The rebate amount.
 * @param updateTime The rebate update time.
 * @see RebateType
 */
@JsonIgnoreProperties(ignoreUnknown = true)
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
		BigDecimal amount,
		/** The rebate update time */
		long updateTime) {
}
