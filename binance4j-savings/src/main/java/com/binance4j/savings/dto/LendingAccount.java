package com.binance4j.savings.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Lending account.
 * 
 * @param positionAmountVos      Position amount.
 * @param totalAmountInBTC       Total amount in btc.
 * @param totalAmountInUSDT      Total amount in usdt.
 * @param totalFixedAmountInBTC  Total fixed amount in btc.
 * @param totalFixedAmountInUSDT Total fixed amount in usdt.
 * @param totalFlexibleInBTC     Total flexible in btc.
 * @param totalFlexibleInUSDT    Total flexible in usdt.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record LendingAccount(
		/** Position amount. */
		List<PositionAmount> positionAmountVos,
		/** Total amount in btc. */
		BigDecimal totalAmountInBTC,
		/** Total amount in usdt. */
		BigDecimal totalAmountInUSDT,
		/** Total fixed amount in btc. */
		BigDecimal totalFixedAmountInBTC,
		/** Total fixed amount in usdt. */
		BigDecimal totalFixedAmountInUSDT,
		/** Total flexible in btc. */
		BigDecimal totalFlexibleInBTC,
		/** Total flexible in usdt. */
		BigDecimal totalFlexibleInUSDT) {
}
