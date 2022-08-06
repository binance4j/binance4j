package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
@ApiModel("")
public record Account(@ApiModelProperty("") String makerCommission, @ApiModelProperty("") String takerCommission, @ApiModelProperty("") String buyerCommission,
		@ApiModelProperty("") String sellerCommission, @ApiModelProperty("") boolean canTrade, @ApiModelProperty("") boolean canWithdraw,
		@ApiModelProperty("") boolean canDeposit, @ApiModelProperty("") long updateTime, @ApiModelProperty("") List<AssetBalance> balances,
		@ApiModelProperty("") String accountType, @ApiModelProperty("") List<String> permissions) {
}