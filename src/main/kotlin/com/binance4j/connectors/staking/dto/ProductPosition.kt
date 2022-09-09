package com.binance4j.connectors.staking.dto

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty


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
 * @property estExtraRewardAmt     Rewards of extra staking type, distribute when order expires.
 * @property nextInterestPay       Next estimated interest payment.
 * @property nextInterestPayDate   Next interest payment date.
 * @property payInterestPeriod     Interest cycle.
 * @property redeemAmountEarly     Early redemption amount.
 * @property interestEndDate       Interest accrual end date.
 * @property deliverDate           Redemption arrival time.
 * @property redeemPeriod          Redemption interval.
 * @property redeemingAmt          Amount under redemption.
 * @property partialAmtDeliverDate Arrival time of partial redemption amount of order.
 * @property canRedeemEarly        When it is true, early redemption can be operated.
 * @property renewable             When it is true, auto staking can be operated.
 * @property type                  Order type is auto-staking or normal.
 * @property status                Position status.
 */
@ApiModel("Product position.")
data class ProductPosition(
    @ApiModelProperty("Staking position ID.")
    @JsonProperty("positionId")
    var positionId: String,
    @ApiModelProperty("Staking project ID.")
    @JsonProperty("productId")
    var productId: String,
    @ApiModelProperty("Locked asset.")
    @JsonProperty("asset")
    var asset: String,
    @ApiModelProperty("Locked Amount.")
    @JsonProperty("amount")
    var amount: String,
    @ApiModelProperty("Subscription time.")
    @JsonProperty("purchaseTime")
    var purchaseTime: String,
    @ApiModelProperty("Lock period(days ).")
    @JsonProperty("duration")
    var duration: String,
    @ApiModelProperty("Accrue days.")
    @JsonProperty("accrualDays")
    var accrualDays: String,
    @ApiModelProperty("Earned asset.")
    @JsonProperty("rewardAsset")
    var rewardAsset: String,
    @ApiModelProperty("APY.")
    @JsonProperty("apy")
    var apy: String,
    @ApiModelProperty("Earned amount.")
    @JsonProperty("rewardAmt")
    var rewardAmt: String,
    @ApiModelProperty("Rewards assets of extra staking type.")
    @JsonProperty("extraRewardAsset")
    var extraRewardAsset: String?,
    @ApiModelProperty("APY of extra staking type.")
    @JsonProperty("extraRewardAPY")
    var extraRewardAPY: String?,
    @ApiModelProperty("Rewards of extra staking type, distribute when order expires.")
    @JsonProperty("estExtraRewardAmt")
    var estExtraRewardAmt: String?,
    @ApiModelProperty("Next estimated interest payment.")
    @JsonProperty("nextInterestPay")
    var nextInterestPay: String,
    @ApiModelProperty("Next interest payment date.")
    @JsonProperty("nextInterestPayDate")
    var nextInterestPayDate: String?,
    @ApiModelProperty("Interest cycle.")
    @JsonProperty("payInterestPeriod")
    var payInterestPeriod: String,
    @ApiModelProperty("Early redemption amount.")
    @JsonProperty("redeemAmountEarly")
    var redeemAmountEarly: String,
    @ApiModelProperty("Interest accrual end date.")
    @JsonProperty("interestEndDate")
    var interestEndDate: String,
    @ApiModelProperty("Redemption arrival time.")
    @JsonProperty("deliverDate")
    var deliverDate: String,
    @ApiModelProperty("Redemption interval.")
    @JsonProperty("redeemPeriod")
    var redeemPeriod: String,
    @ApiModelProperty("Amount under redemption.")
    @JsonProperty("redeemingAmt")
    var redeemingAmt: String?,
    @ApiModelProperty("Arrival time of partial redemption amount of order.")
    @JsonProperty("partialAmtDeliverDate")
    var partialAmtDeliverDate: String?,
    @ApiModelProperty("When it is true, early redemption can be operated.")
    @JsonProperty("canRedeemEarly")
    var canRedeemEarly: Boolean,
    @ApiModelProperty("When it is true, auto staking can be operated.")
    @JsonProperty("renewable")
    var renewable: Boolean,
    @ApiModelProperty("Order type is auto-staking or normal.")
    @JsonProperty("type")
    var type: String,
    @ApiModelProperty("Position status.")
    @JsonProperty("status")
    var status: String
)