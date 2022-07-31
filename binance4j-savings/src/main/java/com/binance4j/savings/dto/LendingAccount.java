package com.binance4j.savings.dto;

import java.util.List;

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
public record LendingAccount(List<PositionAmount> positionAmountVos, String totalAmountInBTC, String totalAmountInUSDT, String totalFixedAmountInBTC,
		String totalFixedAmountInUSDT, String totalFlexibleInBTC, String totalFlexibleInUSDT) {
}
