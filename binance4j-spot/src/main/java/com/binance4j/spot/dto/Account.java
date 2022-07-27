package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * The SPOT account information.
 * 
 * @param makerCommission  The maker commission.
 * @param takerCommission  The taker commission.
 * @param buyerCommission  The buyer commission.
 * @param sellerCommission The seller commission.
 * @param canTrade         The trade permission.
 * @param canWithdraw      The withdrawal permission.
 * @param canDeposit       The deposit permission.
 * @param updateTime       The timestamp of the last data update.
 * @param balances         The balances of each asset in the SPOT wallet.
 * @param accountType      The account Type .
 * @param permissions      The permissions list.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
		/** The maker commission. */
		String makerCommission,
		/** The taker commission. */
		String takerCommission,
		/** The buyer commission. */
		String buyerCommission,
		/** The seller commission. */
		String sellerCommission,
		/** The trade permission. */
		boolean canTrade,
		/** The withdrawal permission. */
		boolean canWithdraw,
		/** The deposit permission. */
		boolean canDeposit,
		/** The timestamp of the last data update. */
		long updateTime,
		/** The balances of each asset in the SPOT wallet. */
		List<AssetBalance> balances,
		/** The account Type. */
		String accountType,
		/** The permissions list. */
		List<String> permissions) {
}