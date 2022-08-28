package com.binance4j.staking.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Product position.
 * 
 * @property positionId            Staking position ID.
 * @property productId             Staking project ID.
 * @property asset                 Locked asset.
 * @property amount                Locked Amount.
 * @property purchaseTime          Subscription time.
 * @property duration              Lock period(days ).
 * @property accrualDays           Accrue days.
 * @property rewardAsset           Earned asset.
 * @property apy                   APY.
 * @property rewardAmt             Earned amount.
 * @property extraRewardAsset      Rewards assets of extra staking type.
 * @property extraRewardAPY        APY of extra staking type.
 * @property estExtraRewardAmt     Rewards of extra staking type, distribute when
 *                              order expires.
 * @property nextInterestPay       Next estimated interest payment.
 * @property nextInterestPayDate   Next interest payment date.
 * @property payInterestPeriod     Interest cycle.
 * @property redeemAmountEarly     Early redemption amount.
 * @property interestEndDate       Interest accrual end date.
 * @property deliverDate           Redemption arrival time.
 * @property redeemPeriod          Redemption interval.
 * @property redeemingAmt          Amount under redemption.
 * @property partialAmtDeliverDate Arrival time of partial redemption amount of
 *                              order.
 * @property canRedeemEarly        When it is true, early redemption can be
 *                              operated.
 * @property renewable             When it is true, auto staking can be operated.
 * @property type                  Order type is auto-staking or normal.
 * @property status                Position status.
 */
@ApiModel("Product position.")
data class ProductPosition(
@ApiModelProperty("Staking position ID.")
var positionId:String?=null,
@ApiModelProperty("Staking project ID.")
var productId:String?=null,
@ApiModelProperty("Locked asset.")
var asset:String?=null,
@ApiModelProperty("Locked Amount.")
var amount:String?=null,
@ApiModelProperty("Subscription time.")
var purchaseTime:String?=null,
@ApiModelProperty("Lock period(days ).") String duration,
@ApiModelProperty("Accrue days.")
var accrualDays:String?=null,
@ApiModelProperty("Earned asset.")
var rewardAsset:String?=null,
@ApiModelProperty("APY.")
var apy:String?=null,
@ApiModelProperty("Earned amount.")
var rewardAmt:String?=null,
@ApiModelProperty("Rewards assets of extra staking type.")
var extraRewardAsset:String?=null,
@ApiModelProperty("APY of extra staking type.")
var extraRewardAPY:String?=null,
@ApiModelProperty("Rewards of extra staking type, distribute when order expires.") String estExtraRewardAmt,
@ApiModelProperty("Next estimated interest payment.")
var nextInterestPay:String?=null,
@ApiModelProperty("Next interest payment date.")
var nextInterestPayDate:String?=null,
@ApiModelProperty("Interest cycle.")
var payInterestPeriod:String?=null,
@ApiModelProperty("Early redemption amount.")
var redeemAmountEarly:String?=null,
@ApiModelProperty("Interest accrual end date.")
var interestEndDate:String?=null,
@ApiModelProperty("Redemption arrival time.")
var deliverDate:String?=null,
@ApiModelProperty("Redemption interval.")
var redeemPeriod:String?=null,
@ApiModelProperty("Amount under redemption.")
var redeemingAmt:String?=null,
@ApiModelProperty("Arrival time of partial redemption amount of order.")
var partialAmtDeliverDate:String?=null,
@ApiModelProperty("When it is true, early redemption can be operated.") boolean canRedeemEarly,
@ApiModelProperty("When it is true, auto staking can be operated.")
boolean renewable,
@ApiModelProperty("Order type is auto-staking or normal.")
String type,
@ApiModelProperty("Position status.")
var status:String?=null)
{
}