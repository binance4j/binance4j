package com.binance4j.spot.dto;

import java.math.BigDecimal;
import java.util.List;

import com.binance4j.core.dto.AccountType;
import com.binance4j.core.dto.AssetBalance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** The SPOT account information */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		/** The maker commission. */
		BigDecimal makerCommission,
		/** The taker commission. */
		BigDecimal takerCommission,
		/** The buyer commission. */
		BigDecimal buyerCommission,
		/** The seller commission. */
		BigDecimal sellerCommission,
		/** The trade permission. */
		Boolean canTrade,
		/** The withdrawal permission. */
		Boolean canWithdraw,
		/** The deposit permission. */
		Boolean canDeposit,
		/** The timestamp of the last data update. */
		Long updateTime,
		/** The balances of each asset in the SPOT wallet. */
		List<AssetBalance> balances,
		/** The account Type (SPOT). */
		AccountType accountType,
		/** The permissions list (SPOT). */
		List<AccountType> permissions) {
}
