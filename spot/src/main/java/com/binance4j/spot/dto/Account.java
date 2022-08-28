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
var makerCommission:String?=null,
@ApiModelProperty("Taker commission.")
var takerCommission:String?=null,
@ApiModelProperty("Buyer commission.")
var buyerCommission:String?=null,
@ApiModelProperty("Seller commission.")
var sellerCommission:String?=null,
@ApiModelProperty("Trade permission.")
var canTrade:Boolean?=null,
@ApiModelProperty("Withdrawal permission.")
var canWithdraw:Boolean?=null,
@ApiModelProperty("Deposit permission.")
var canDeposit:Boolean?=null,
@ApiModelProperty("Timestamp of the last data update.")
var updateTime:Long?=null,
@ApiModelProperty("Balances of each asset in the SPOT wallet.") List<AssetBalance> balances,
@ApiModelProperty("Account Type .")
var accountType:String?=null,
@ApiModelProperty("Permissions list.") List<String> permissions,
@ApiModelProperty("Brokered account?") var brokered:Boolean?=null)
{
}