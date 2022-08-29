package com.binance4j.spot.dto;

import java.util.List;

import com.binance4j.core.dto.AssetBalance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The SPOT account information.
 * 
 * @property makerCommission  Maker commission.
 * @property takerCommission  Taker commission.
 * @property buyerCommission  Buyer commission.
 * @property sellerCommission Seller commission.
 * @property canTrade         Trade permission.
 * @property canWithdraw      Withdrawal permission.
 * @property canDeposit       Deposit permission.
 * @property updateTime       Timestamp of the last data update.
 * @property balances         Balances of each asset in the SPOT wallet.
 * @property accountType      Account Type .
 * @property permissions      Permissions list.
 * @property brokered         Brokered account?
 */
@ApiModel("The SPOT account information.")
data class Account(
@ApiModelProperty("Maker commission.")
 val makerCommission : String,
@ApiModelProperty("Taker commission.")
 val takerCommission : String,
@ApiModelProperty("Buyer commission.")
 val buyerCommission : String,
@ApiModelProperty("Seller commission.")
 val sellerCommission : String,
@ApiModelProperty("Trade permission.")
 val canTrade : Boolean,
@ApiModelProperty("Withdrawal permission.")
 val canWithdraw : Boolean,
@ApiModelProperty("Deposit permission.")
 val canDeposit : Boolean,
@ApiModelProperty("Timestamp of the last data update.")
 val updateTime : Long,
@ApiModelProperty("Balances of each asset in the SPOT wallet.") List<AssetBalance> balances,
@ApiModelProperty("Account Type .")
 val accountType : String,
@ApiModelProperty("Permissions list.") List<String> permissions,
@ApiModelProperty("Brokered account?")  val brokered : Boolean)
{
}