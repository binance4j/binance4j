package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The SPOT account information.
 * 
 * @param makerCommission  Maker commission.
 * @param takerCommission  Taker commission.
 * @param buyerCommission  Buyer commission.
 * @param sellerCommission Seller commission.
 * @param canTrade         Trade permission.
 * @param canWithdraw      Withdrawal permission.
 * @param canDeposit       Deposit permission.
 * @param updateTime       Timestamp of the last data update.
 * @param balances         Balances of each asset in the SPOT wallet.
 * @param accountType      Account Type .
 * @param permissions      Permissions list.
 * @param brokered         Brokered account?
 */
@ApiModel("The SPOT account information.")
public record Account(@ApiModelProperty("Maker commission.") String makerCommission, @ApiModelProperty("Taker commission.") String takerCommission,
		@ApiModelProperty("Buyer commission.") String buyerCommission, @ApiModelProperty("Seller commission.") String sellerCommission,
		@ApiModelProperty("Trade permission.") boolean canTrade, @ApiModelProperty("Withdrawal permission.") boolean canWithdraw,
		@ApiModelProperty("Deposit permission.") boolean canDeposit, @ApiModelProperty("Timestamp of the last data update.") long updateTime,
		@ApiModelProperty("Balances of each asset in the SPOT wallet.") List<AssetBalance> balances, @ApiModelProperty("Account Type .") String accountType,
		@ApiModelProperty("Permissions list.") List<String> permissions, @ApiModelProperty("Brokered account?") boolean brokered) {
}