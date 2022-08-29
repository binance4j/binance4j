/*
 * MIT License
 *
 * Copyright (c) 2022 Binance4j
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.binance4j.staking.dto

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
    @JsonProperty("positionId")
    var positionId: String? = null,

    @ApiModelProperty("Staking project ID.")
    @JsonProperty("productId")
    var productId: String? = null,

    @ApiModelProperty("Locked asset.")
    @JsonProperty("asset")
    var asset: String? = null,

    @ApiModelProperty("Locked Amount.")
    @JsonProperty("amount")
    var amount: String? = null,

    @ApiModelProperty("Subscription time.")
    @JsonProperty("purchaseTime")
    var purchaseTime: String? = null,

    @ApiModelProperty("Lock period(days ).")
    @JsonProperty("duration")
    var duration: String? = null,
    @ApiModelProperty("Accrue days.")
    @JsonProperty("accrualDays")
    var accrualDays: String? = null,

    @ApiModelProperty("Earned asset.")
    @JsonProperty("rewardAsset")
    var rewardAsset: String? = null,

    @ApiModelProperty("APY.")
    @JsonProperty("apy")
    var apy: String? = null,

    @ApiModelProperty("Earned amount.")
    @JsonProperty("rewardAmt")
    var rewardAmt: String? = null,

    @ApiModelProperty("Rewards assets of extra staking type.")
    @JsonProperty("extraRewardAsset")
    var extraRewardAsset: String? = null,

    @ApiModelProperty("APY of extra staking type.")
    @JsonProperty("extraRewardAPY")
    var extraRewardAPY: String? = null,

    @JsonProperty("extraRewardAPY")
    @ApiModelProperty("Rewards of extra staking type, distribute when order expires.")
    var estExtraRewardAmt: String? = null,

    @ApiModelProperty("Next estimated interest payment.")
    @JsonProperty("nextInterestPay")
    var nextInterestPay: String? = null,

    @ApiModelProperty("Next interest payment date.")
    @JsonProperty("nextInterestPayDate")
    var nextInterestPayDate: String? = null,

    @ApiModelProperty("Interest cycle.")
    @JsonProperty("payInterestPeriod")
    var payInterestPeriod: String? = null,

    @ApiModelProperty("Early redemption amount.")
    @JsonProperty("redeemAmountEarly")
    var redeemAmountEarly: String? = null,

    @ApiModelProperty("Interest accrual end date.")
    @JsonProperty("interestEndDate")
    var interestEndDate: String? = null,

    @ApiModelProperty("Redemption arrival time.")
    @JsonProperty("deliverDate")
    var deliverDate: String? = null,

    @ApiModelProperty("Redemption interval.")
    @JsonProperty("redeemPeriod")
    var redeemPeriod: String? = null,

    @ApiModelProperty("Amount under redemption.")
    @JsonProperty("redeemingAmt")
    var redeemingAmt: String? = null,

    @ApiModelProperty("Arrival time of partial redemption amount of order.")
    @JsonProperty("partialAmtDeliverDate")
    var partialAmtDeliverDate: String? = null,

    @ApiModelProperty("When it is true, early redemption can be operated.")
    @JsonProperty("canRedeemEarly")
    var canRedeemEarly: Boolean? = null,

    @ApiModelProperty("When it is true, auto staking can be operated.")
    @JsonProperty("renewable")
    var renewable: Boolean? = null,

    @ApiModelProperty("Order type is auto-staking or normal.")
    @JsonProperty("type")
    var type: String? = null,

    @ApiModelProperty("Position status.")
    @JsonProperty("status")
    var status: String? = null
)