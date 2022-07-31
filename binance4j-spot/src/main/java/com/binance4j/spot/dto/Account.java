package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

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
public record Account(String makerCommission, String takerCommission, String buyerCommission, String sellerCommission, boolean canTrade, boolean canWithdraw,
		boolean canDeposit, long updateTime, List<AssetBalance> balances, String accountType, List<String> permissions) {
}