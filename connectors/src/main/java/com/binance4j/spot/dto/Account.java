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
@JsonProperty("makerCommission") var makerCommission:String?=null,
@ApiModelProperty("Taker commission.")
@JsonProperty("takerCommission") var takerCommission:String?=null,
@ApiModelProperty("Buyer commission.")
@JsonProperty("buyerCommission") var buyerCommission:String?=null,
@ApiModelProperty("Seller commission.")
@JsonProperty("sellerCommission") var sellerCommission:String?=null,
@ApiModelProperty("Trade permission.")
@JsonProperty("canTrade") var canTrade:Boolean?=null,
@ApiModelProperty("Withdrawal permission.")
@JsonProperty("canWithdraw") var canWithdraw:Boolean?=null,
@ApiModelProperty("Deposit permission.")
@JsonProperty("canDeposit") var canDeposit:Boolean?=null,
@ApiModelProperty("Timestamp of the last data update.")
@JsonProperty("updateTime") var updateTime:Long?=null,
@ApiModelProperty("Balances of each asset in the SPOT wallet.") List<AssetBalance> balances,
@ApiModelProperty("Account Type .")
@JsonProperty("accountType") var accountType:String?=null,
@ApiModelProperty("Permissions list.") List<String> permissions,
@ApiModelProperty("Brokered account?") @JsonProperty("brokered") var brokered:Boolean?=null)
{
}